package com.quake.logReader.models;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class Game {

    private Integer numeroGame;

    //Todas as kills que aconteceram na partida.
    private Integer totalKills;

    //Dados dos Jogadores
    private List<Jogador> jogadores;

    private LocalTime inicioPartida;

    private LocalTime fimPartida;

    public Integer getNumeroGame() {
        return numeroGame;
    }

    public void setNumeroGame(Integer numeroGame) {
        this.numeroGame = numeroGame;
    }

    public Integer getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(Integer totalKills) {
        this.totalKills = totalKills;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public LocalTime getInicioPartida() {
        return inicioPartida;
    }

    public void setInicioPartida(LocalTime inicioPartida) {
        this.inicioPartida = inicioPartida;
    }

    public LocalTime getFimPartida() {
        return fimPartida;
    }

    public void setFimPartida(LocalTime fimPartida) {
        this.fimPartida = fimPartida;
    }
}
