package org.example;

public class Main1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int i = 1;

        do {
            System.out.print(i);
            i = 1 + (i + m - 2) % n;
        } while (i != 1);
    }
}
