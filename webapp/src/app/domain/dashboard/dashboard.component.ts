import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  templateUrl: './dashboard.component.html'
})
export class DashboardComponent {

  constructor(
    private http: HttpClient
  ) { }

  existArquivo = false;
  formData = new FormData();
  nomeArquivo = "Nenhum arquivo selecionado.";

  inputFileChange(event) {
    if(event.target.files && event.target.files[0]) {
      const arquivo = event.target.files[0];
      this.formData.append('arquivo', arquivo);
      this.nomeArquivo = event.target.files[0].name;
      this.existArquivo = true;
    }
  }
  
  gerarLog() {
    this.http.post('http://localhost:8080/arquivoLog', this.formData).subscribe(response => console.log('upload Ok'));
  }

}
