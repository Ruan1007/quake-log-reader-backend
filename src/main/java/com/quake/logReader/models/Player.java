package com.quake.logReader.models;

import java.util.List;

public class Player {

    private Integer playerCod;

    private String playerName;

    private Integer kills;

    private Integer suicide;

    private List<String> typeOfDeaths;

    private boolean isFisrtPlayer;

    public Player(Integer playerCod, String playerName, Integer kills, Integer suicide) {
        this.playerCod = playerCod;
        this.playerName = playerName;
        this.kills = kills;
        this.suicide = suicide;
    }

    public Integer getPlayerCod() {
        return playerCod;
    }

    public void setPlayerCod(Integer playerCod) {
        this.playerCod = playerCod;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Retorna a quantidade de kills menos a quantidade de suicides.
     * @return
     */
    public Integer getKills() {
        return kills - suicide;
    }

    public void setKills(Integer kills) {
        this.kills += kills;
    }

    public Integer getSuicide() {
        return suicide;
    }

    public void setSuicide(Integer suicide) {
        this.suicide += suicide;
    }

    public List<String> getTypeOfDeaths() {
        return typeOfDeaths;
    }

    public void setTypeOfDeaths(List<String> typeOfDeaths) {
        this.typeOfDeaths = typeOfDeaths;
    }

    public void addKills(Integer kill) {
        if(this.kills == null) {
            this.kills = 0;
        }
        this.kills += kill;
    }

    public void addSuicide(Integer kill) {
        if(this.suicide == null) {
            this.suicide = 0;
        }
        this.suicide += kill;
    }

    public boolean isFisrtPlayer() {
        return isFisrtPlayer;
    }

    public void setFisrtPlayer(boolean fisrtPlayer) {
        isFisrtPlayer = fisrtPlayer;
    }
}
