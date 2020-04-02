package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static com.company.GCF.lenghtOfLongestAP;

public class Player implements Runnable {
    public static Comparator<Token> SortByValue = new Comparator<Token>() {
        @Override
        public int compare(Token o1, Token o2) {
            if (o1.getValue() > o2.getValue()) return 1;
            else if (o1.getValue() == o2.getValue()) return 0;
            return -1;
        }
    };
    public String name;
    private Board board;
    private Token token;
    private ArrayList<Token> progression = new ArrayList<>();


    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    public ArrayList<Token> getProgression() {
        return progression;
    }

    @Override
    public String toString() {
        return "Player{" +
                "progression=" + progression +
                '}';
    }

    public String getName() {
        return name;
    }

    public void sort() {
        Collections.sort(progression, SortByValue);
    }


    public int getScore() {
        sort();
        return lenghtOfLongestAP(progression);
    }

    @Override
    public void run() {


        while (true) {
            try {
                Thread.sleep(300);
                System.out.println("Thread starting...");
                System.out.println("Player " + name + " takes the token  ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                token = board.TokenGetter();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (token == null) {
                break;
            }
            progression.add(token);


        }

    }


}
