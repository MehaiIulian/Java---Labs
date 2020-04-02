package com.company;


import java.util.ArrayList;

import java.util.Random;

public class Board {
    public ArrayList<Token> tokens=new ArrayList<>();
    private Token token;

    public Board(int n, int m){
        Random random = new Random();
        for (int i=0; i<n; i++)
        {
            int val = random.nextInt(m);
            tokens.add(new Token(val));

        }
    }

    @Override
    public String toString() {
        return "Board{" +
                "tokens=" + tokens +
                '}';
    }


    public synchronized Token TokenGetter() throws InterruptedException
    {
        System.out.println("running..." );
        if(tokens.size()==0) return null;
        else
        {
            token=tokens.get(0);
            tokens.remove(token);
            return token;
        }

    }
}
