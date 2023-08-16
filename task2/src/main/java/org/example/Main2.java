package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        String path1 = args[0];
        String path2 = args[1];

        try {
            Scanner sc1 = new Scanner(new File(path1));
            String[] split1 = sc1.nextLine().split(" ");
            float x = Float.parseFloat(split1[0]);
            float y = Float.parseFloat(split1[1]);
            float r = Float.parseFloat(sc1.nextLine());

            Scanner sc2 = new Scanner(new File(path2));
            while (sc2.hasNextLine()) {
                String[] split2 = sc2.nextLine().split(" ");
                float x2 = Float.parseFloat(split2[0]);
                float y2 = Float.parseFloat(split2[1]);

                double v = Math.pow((x2 - x), 2) + Math.pow((y2 - y), 2);

                if (v < Math.pow(r, 2)) {
                    System.out.println(1);
                } else if (v == Math.pow(r, 2)) {
                    System.out.println(0);
                } else {
                    System.out.println(2);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
