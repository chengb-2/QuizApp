package com.bfs.andyb.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DBUtil {
    public static void main(String[] args) {
        // generate choices
//        for (int i = 1; i <= 10; i++) {
//
//            System.out.println(String.format("(%d, \"%d\", true),", i, i));
//            for (int j = 0; j < 3; j++) {
//                System.out.println(String.format("(%d, \"%d\", false),", i, i+j+1));
//            }
//        }

//        String[] answer = new String[]{"Hydrogen", "Helium", "Lithium", "Beryllium", "Boron", "Carbon", "Nitrogen", "Oxygen", "Fluorine", "Neon"};
//        String[] answer = new String[]{"Sodium", "Magnesium", "Aluminium", "Silicon", "Phosphorus", "Sulfur", "Chlorine", "Argon", "Potassium", "Calcium"};
//
//        for (int i = 21; i <= 30; i++) {
//            System.out.println(String.format("(%d, \"%s\", true),", i, answer[i-21]));
//            for (int j = 1; j <= 3; j++) {
//                System.out.println(String.format("(%d, \"%s\", false),", i, "mumbo jumbo: " + i + "-" + j));
//            }
//        }

//        String[] answer = new String[]{"Hydrogen", "Helium", "Oxygen", "Sulfur", "Silicone"};
//
//        for (int i = 16; i <= 20; i++) {
//            System.out.println(String.format("(%d, \"%s\", true),", i, answer[i-16]));
//            for (int j = 1; j <= 3; j++) {
//                System.out.println(String.format("(%d, \"%s\", false),", i, "mumbo jumbo: " + i + "-" + j));
//            }
//        }


//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        System.out.println(sdf.format(timestamp));
//        System.out.println(timestamp);

        String[] products = new String[]{"iPhone 13", "iPad Pro", "AirPods Pro", "AirPods", "Apple Watch Series 8"};
        double[] retail_price = new double[]{999, 799, 249, 99.99, 329.99};
        double[] wholesale_price = new double[]{899, 699, 149, 49.99, 229.99};

//        (name, description, stock_quantity, retail_price, wholesale_price, total_sold, total_profit)
        for (int i = 0; i < 5; i++) {
            System.out.println(String.format("(\"%s\", \"%s\", %d, %f, %f, %d, %f),", products[i], products[i]+" description", 10, retail_price[i], wholesale_price[i], 0, 0.0));

        }





    }
}
