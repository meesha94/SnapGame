package org.example;

public class Player extends Snap {
    private String name;


    public Player(String gameName, String name) {
        super(gameName);
        this.name = name;

    }

    public String getName() {

        return name;
    }

}


