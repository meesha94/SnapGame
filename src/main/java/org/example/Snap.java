package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Snap extends CardGame {
    private Scanner scanner = new Scanner(System.in);
    private Card previousCard;
    private String currentCardSymbol;
    private String previousCardSymbol;
    private Card currentCard;
    private String currentPlayer;
    private ArrayList<String> players = new ArrayList<>();
    private double snapStart;
    private double snapTime;

    public Snap(String nameGame) {
        super(nameGame);
    }

    public void snap() {
        this.makeTeam();
        this.createDeck();
        this.shuffleDeck();
        this.setPlayer();
    }

    public void makeTeam() {
        Player player1 = new Player("Snap", "Player 1");
        Player player2 = new Player("Snap", "Player 2");
        players.add(player1.getName());
        players.add(player2.getName());

        System.out.println("Welcome to the Snap Game!");
        System.out.println("This is a two player game of Snap");
        System.out.println();
    }

    public void setPlayer() {
        if (currentPlayer == null) {
            currentPlayer = players.get(0);
        } else if (currentPlayer.equals(players.get(0))) {
            currentPlayer = players.get(1);
        } else {
            currentPlayer = players.get(0);
        }
        this.play();
    }

    public void play() {
        previousCard = currentCard;

        System.out.println();
        System.out.println();
        System.out.println(currentPlayer + " press 'Enter' to play");
        String enter = scanner.nextLine();

        currentCard = this.dealCard();
        currentCardSymbol = currentCard.getSymbol();

        if (previousCard != null) {
            previousCardSymbol = previousCard.getSymbol();
        }

        checkSnap();
    }

    public void checkSnap() {
        if (Objects.equals(currentCardSymbol, previousCardSymbol)) {
            snapStart = System.currentTimeMillis();

            String isSnap = scanner.next();
            snapTime = System.currentTimeMillis();

            if (isSnap.toLowerCase().equalsIgnoreCase("snap") && ((snapTime - snapStart) <= 2000)) {
                System.out.println("SNAP!!!  Game over. " + currentPlayer + " You won the game!");

            } else {
                System.out.println(" Oh no! You missed the snap! ");

                this.setPlayer();
            }
        } else {
            this.setPlayer();
        }
    }

}