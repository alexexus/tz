package org.example;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        circleArray();
    }

    public static void circleArray() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int i = 1;

        do {
            System.out.print(i);
            i = 1 + (i + m - 2) % n;
        } while (i != 1);
    }
}
