package com.company;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = 40;
        int m = 25;

        Board board = new Board(n, m);


        Thread.sleep(200);

        int k=8;
        Game game = new Game(board, k);
        game.addPlayers("Player1");
        game.addPlayers("Player2");
        game.addPlayers("Player3");
        game.addPlayers("Player4");
        long Starttime = System.currentTimeMillis();
        game.Threading();
        game.play();
        long finaltime = System.currentTimeMillis();
        game.getScores();
        System.out.println("this game took: " + (finaltime - Starttime) + " ms ");


    }
}
