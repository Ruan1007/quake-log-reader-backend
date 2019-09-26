package com.quake.logReader.models;

public enum TextSystemLog {


    INIT_GAME("InitGame"),
    MAP("Map"),
    DEFAULT_PICKUP("Default pickup mode is"),
    ARENA_CONFIG("arena.cfg info for map found"),
    CLIENT_USER_INFO_CHANGED("ClientUserinfoChanged"),
    CLIENT_CONNECT("ClientConnect"),
    CLIENT_DISCONNECT("ClientDisconnect"),
    SHUTDOWN_GAME("ShutdownGame"),
    RED("red"),
    EXIT("Exit"),
    CLIENT_BEGIN("ClientBegin"),
    SCORE("score"),
    ITEM("Item"),
    TELL("tell"),
    SPAWNHEAD("spawnhead"),
    TOUCHHEAD("touchhead"),
    ALTAR_SCORE("AltarScore"),
    CLIENT_USER_INFO("ClientUserinfo"),
    WARMUP("Warmup"),


    TXTKILL("Kill"),
    TXTKILLED("killed"),
    TXTGAME("------------------------------------------------------------"),
    TXTSUICIDE("<world>"),
    TXTTOTALS("TOTALS"),
    TXTOPONENTS("OPONENTS");

    public static final String BREAK = ":";
    public static final String SPACE = " ";
    public static final String EQUALS = "=";

    private String textSystem;

    TextSystemLog(String textSystem) {
        this.textSystem = textSystem;
    }

    public String getTextSystem() {
        return this.textSystem;
    }

}
