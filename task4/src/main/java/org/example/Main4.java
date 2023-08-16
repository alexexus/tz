package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) throws FileNotFoundException {
        String path = args[0];
        List<Integer> list = new ArrayList<>();

        Scanner sc1 = new Scanner(new File(path));
        while (sc1.hasNextLine()) {
            list.add(sc1.nextInt());
        }

        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        int med = sum / list.size();
        int sum2 = 0;
        for (Integer i : list) {
            sum2 += Math.abs(med - i);
        }
        System.out.println(sum2);
    }
}
