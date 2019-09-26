package com.quake.logReader.models;

public enum TipoLog {

    NOTHING(0),
    SYSTEM(1),
    CHAT(2),
    KILL(3),
    GAME(4);

    private int codTipo;

    TipoLog(int codTipo) {
        this.codTipo = codTipo;
    }

    public int getCodTipo(){
        return codTipo;
    }
}
