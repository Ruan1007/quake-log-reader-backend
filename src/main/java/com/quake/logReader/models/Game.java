package com.quake.logReader.models;

import java.util.List;

public class Game {

    private Integer gameNumber;

    //Todas as kills que aconteceram na partida.
    private Integer totalKills;

    //Dados dos Jogadores
    private List<Player> players;

    private String playersName;

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

    public void addTotalKills(Integer kill) {
        if(this.totalKills == null) {
            this.totalKills = 0;
        }
        this.totalKills += kill;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getPlayersName() {
        return playersName;
    }

    public void setPlayersName(String playersName) {
        this.playersName = playersName;
    }
}
