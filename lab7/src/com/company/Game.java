package com.company;

import java.util.ArrayList;

public class Game {
    private Board board;
    private Player player;
    private ArrayList<Player> players = new ArrayList<>();
    private int k;
    private ArrayList<Thread> threads = new ArrayList<>();

    public Game(Board board, int k) {
        this.board = board;
        this.k = k;
    }

    void addPlayers(String name) {

        player = new Player(name, board);
        players.add(player);

    }


    public void getScores() {

        boolean end = false;
        for (Player player : players ) {
            int score = player.getScore();

            if (k <= score && end == false) {
                System.out.println("Player:" + player.getName() + " has won the game with:" + score );
                end = true;
            }

        }


        if (end == false) {
            System.out.println("Nobody won and the scores are:");
            for (Player player : players) {
                int score = player.getScore();
                System.out.println("Player " + player.getName() + " has " + score + " and has the progression " + player.getProgression());
            }

        }
    }

    public void Threading() {
        for (Player player : players) {

            Thread thread = new Thread(player);
            thread.start();

            threads.add(thread);

        }
    }

    public void play() {


        try {
            for (Thread thread : threads) {

                thread.join();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
