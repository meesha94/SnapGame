package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {
    private String gameName;
    private String [] suits = {"♥","♣","♦","♠"} ;
    private String [] symbols = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"} ;
    private int [] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    protected ArrayList<Card> deckOfCards = new ArrayList<> ();
    private ArrayList<Card> cards = new ArrayList<>();
    private int cardNumber = 0;
    private Card dealCard;

    public CardGame(String gameName) {
        this.gameName = gameName;
    }

    public ArrayList<Card> getDeck() {
        System.out.println("get deck : " + deckOfCards);
        return deckOfCards;
    }

    public void  createDeck () {
        for ( String suit: suits) {
            for (int i = 0; i < symbols.length; i++)  {
                Card card = new Card(suit, symbols[i], values[i]);
                deckOfCards.add(card);
            }
        }
        cardNumber = 0;
    }

    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);
    }


    public Card dealCard(){
        dealCard = deckOfCards.get(cardNumber) ;
        System.out.println(dealCard);
        if (cardNumber == 51) {
            shuffleDeck();
            cardNumber=1;
        } else {
            cardNumber += 1;}
        return dealCard;
    }



    public void sortDeckNumberOrder() {
        System.out.println("before number sort : " + deckOfCards);
        Collections.sort(deckOfCards, new Comparator<Card>() {
            @Override
            public int compare(Card card1, Card card2) {return card1.getValue() - card2.getValue();
            }

        });
        System.out.println("number sorted cards : " + deckOfCards);
    }

    public void sortDeckSuits(){
        System.out.println("before suit : " + deckOfCards);
        Collections.sort(deckOfCards, new Comparator<Card>() {
            @Override
            public int compare(Card card1, Card card2) {
                return card1.getSuit().compareTo(card2.getSuit());
            }
        });
        Collections.sort(deckOfCards, new Comparator<Card>() {
            @Override
            public int compare(Card card1, Card card2) {
                return card1.getValue() - card2.getValue();
            }
        });
        System.out.println("suits sorted cards : " + deckOfCards);

    }






    @Override
    public String toString() {
        return "CardGame{" +
                "nameOfTheGame='" + gameName + '\'' +
                ", suits=" + Arrays.toString(suits) +
                ", symbols=" + Arrays.toString(symbols) +
                ", values=" + Arrays.toString(values) +
                ", deckOfCards=" + deckOfCards +
                ", cards=" + cards +
                '}';
    }

};

