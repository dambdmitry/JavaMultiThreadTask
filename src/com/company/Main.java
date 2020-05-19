package com.company;

public class Main {

    public static void main(String[] args) {
        Traffics left = new Traffics(150, false);
        Traffics right = new Traffics(150, true);

        right.start();
        left.start();
    }
}

