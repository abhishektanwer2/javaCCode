package com;

public class Account implements Comparable<Account> ,OnlineAccount{
    @Override
    public int compareTo(Account o) {
        return 0;
    }

    @Override
    public int basePrice() {
        return 0;
    }

    @Override
    public int regularMoviePrice() {
        return 0;
    }

    @Override
    public int excelsusiveMoviePrice() {
        return 0;
    }
}
