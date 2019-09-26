package com.quake.logReader.models;

public class Jogador {

    private Integer codJogador;

    private String nomeJogador;

    private Integer kills;

    private Integer suicide;

    public Jogador(Integer codJogador, String nomeJogador) {
        this.codJogador = codJogador;
        this.nomeJogador = nomeJogador;
    }

    public Integer getCodJogador() {
        return codJogador;
    }

    public void setCodJogador(Integer codJogador) {
        this.codJogador = codJogador;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    /**
     * Retorna a quantidade de kills menos a quantidade de suicides.
     * @return
     */
    public Integer getKills() {
        return kills - suicide;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Integer getSuicide() {
        return suicide;
    }

    public void setSuicide(Integer suicide) {
        this.suicide = suicide;
    }
}
