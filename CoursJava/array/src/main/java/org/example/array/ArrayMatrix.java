package org.example.array;

public class ArrayMatrix {

    static int[][] matrix = {{1,2,4},{1,2,4,7},{1,2,4}};

    public static void getMatrix() {
      //  System.out.println(matrix[0][2]);

        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static void getMatrix2() {

       int[][] tableau = new int[3][4];

        for (int i = 0; i <tableau.length ; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                System.out.print(tableau[i][j]  + "|");
            }
            System.out.println();
        }

    }

}
