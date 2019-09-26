import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';

@Component({
  templateUrl: './dashboard.component.html'
})
export class DashboardComponent {

  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();

  constructor(
    private http: HttpClient
  ) { }

  existArquivo = false;
  arquivo : any;
  nomeArquivo = "Nenhum arquivo selecionado.";
  resultLog: any = {};
  games = [];
  viewGame: any = {};

  inputFileChange(event) {
    if(event.target.files && event.target.files[0]) {
      const arquivo = event.target.files[0];
      const formData = new FormData();
      formData.append('arquivo', arquivo);
      this.nomeArquivo = event.target.files[0].name;
      this.existArquivo = true;
      this.arquivo = formData;
      this.resultLog.isOk = false;
    }
  }
  
  gerarLog() {
    this.http.post('http://localhost:8080/arquivoLog', this.arquivo)
    .subscribe(response => {
      this.resultLog = response; 
      this.resultLog.isOk = true;
      this.games = this.resultLog.games;
    });
  }

  viewGameSelected(game) {
    this.viewGame = game;
    this.viewGame.isVisualizar = true;
    this.resultLog.isOk = false;
  }

  return() {
    this.resultLog.isOk = true;
    this.viewGame = undefined;
  }

}
