package com.quake.logReader.models;

import java.util.StringTokenizer;

public enum TypeOfDeath {

    MOD_SHOTGUN(1, "MOD_SHOTGUN"),
    MOD_MACHINEGUN(3, "MOD_MACHINEGUN"),
    MOD_ROCKET(6, "MOD_ROCKET"),
    MOD_ROCKET_SPLASH(7, "MOD_ROCKET_SPLASH"),
    MOD_RAILGUN(10, "MOD_RAILGUN"),
    MOD_BFG(12, "MOD_BFG"),
    MOD_BFG_SPLASH(13, "MOD_BFG_SPLASH"),
    MOD_CRUSH(17, "MOD_CRUSH"),
    MOD_TELEFRAG(18, "MOD_TELEFRAG"),
    MOD_FALLING(19, "MOD_FALLING"),
    MOD_TRIGGER_HURT(22, "MOD_TRIGGER_HURT");

    private Integer id;
    private String name;

    TypeOfDeath(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static TypeOfDeath getTypeOfDeathById(Integer id){
        for(TypeOfDeath t : values()) {
            if(t.id.equals(id)) return t;
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
