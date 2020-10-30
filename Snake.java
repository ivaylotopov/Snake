package com.company;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = Integer.parseInt(input.nextLine()); // size of array
        String [][] array = new String[size][size];
        int row = 0;
        int col = 0;
        int food = 0;
        for (int i = 0; i < size ; i++) {
            String data = input.nextLine();
            array[i] = new String[data.length()];
            for (int j = 0; j < data.length(); j++) {
                array[i][j] = String.valueOf(data.charAt(j));
                if (array[i][j].equals("S")){
                    row = i;
                    col = j;
                }
            }
        }
        while (true){
            String txt = input.nextLine();
            String field;
            array[row][col] = ".";
            if (txt.equals("up")) {
                row--;
                if (row < 0) {
                    System.out.println("Game over!");
                break;
                } else {
                    field = array[row][col];
                    if (field.equals("*")){
                        food++;
                        if (food>=10){
                            array[row][col] = "S";
                            System.out.println("You won! You fed the snake.");
                            break;
                        }
                    } else if (field.equals("B")){

                        for (int i = 0; i < size ; i++) {
                            array[row][col] = ".";
                            for (int j = 0; j < array[i].length; j++) {
                                if (array[i][j].equals("B")){
                                    array[row][col] = ".";
                                    row = i;
                                    col = j;
                                }
                            }
                        }
                    }
                }
            } else if (txt.equals("down")){
                row++;
                if (row > array.length - 1){
                    System.out.println("Game over!");
                    break;
                } else {
                    field = array[row][col];
                    if (field.equals("*")){
                        food++;
                        if (food>=10){
                            array[row][col] = "S";
                            System.out.println("You won! You fed the snake.");
                            break;
                        }
                    } else if (field.equals("B")){
                        array[row][col] = ".";
                        for (int i = 0; i < size ; i++) {
                            for (int j = 0; j < array[i].length; j++) {
                                if (array[i][j].equals("B")){
                                    array[row][col] = ".";
                                    row = i;
                                    col = j;
                                }
                            }
                        }
                    }
                }
            } else if (txt.equals("left")){
                col--;
                if (col < 0){
                    System.out.println("Game over!");
                    break;
                } else {
                    field = array[row][col];
                    if (field.equals("*")){
                        food++;
                        if (food>=10){
                            array[row][col] = "S";
                            System.out.println("You won! You fed the snake.");
                            break;
                        }
                    } else if (field.equals("B")){
                        array[row][col] = ".";
                        for (int i = 0; i < size ; i++) {
                            for (int j = 0; j < array[i].length; j++) {
                                if (array[i][j].equals("B")){
                                    array[row][col] = ".";
                                    row = i;
                                    col = j;
                                }
                            }
                        }
                    }
                }
            } else if (txt.equals("right")){
                col++;
                if (col > array.length-1){
                    System.out.println("Game over!");
                    break;
                } else {
                    field = array[row][col];
                    if (field.equals("*")){
                        food++;
                        if (food>=10){
                            array[row][col] = "S";
                            System.out.println("You won! You fed the snake.");
                            break;
                        }
                    } else if (field.equals("B")){
                        array[row][col] = ".";
                        for (int i = 0; i < size ; i++) {
                            for (int j = 0; j < array[i].length; j++) {
                                if (array[i][j].equals("B")){
                                    array[row][col] = ".";
                                    row = i;
                                    col = j;
                                }
                            }
                        }
                    }
                }
                array[row][col] = "S";
            }
        }
        System.out.printf("Food eaten: %d\n",food);
        for (String[] strings : array) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
}
