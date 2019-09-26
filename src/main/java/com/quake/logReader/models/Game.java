package com.quake.logReader.models;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class Game {

    private Integer gameNumber;

    //Todas as kills que aconteceram na partida.
    private Integer totalKills;

    //Nome dos Jogadores
    private List<String> jogadores;

    // Passar nome do jogador e as kills
    private Map<String, Integer> kills;

    private LocalTime inicioPartida;

    private LocalTime fimPartida;

    public Integer getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(Integer gameNumber) {
        this.gameNumber = gameNumber;
    }

    public Integer getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(Integer totalKills) {
        this.totalKills = totalKills;
    }

    public List<String> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<String> jogadores) {
        this.jogadores = jogadores;
    }

    public Map<String, Integer> getKills() {
        return kills;
    }

    public void setKills(Map<String, Integer> kills) {
        this.kills = kills;
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
