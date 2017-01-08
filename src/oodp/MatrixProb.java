/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Pushpak
 */
public class MatrixProb {

    public static void main(String arg[]) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int matrix[][] = new int[2 * n][2 * n];
        int row = 0;

        for (int loop = 0; loop < 2 * n; loop++) {
            String[] s = br.readLine().split(" ");

            for (int j = 0; j < (2 * n); j++) {
                matrix[row][j] = Integer.parseInt(s[j]);
            }
            
            row++;

        }
        
        

        for (int i = 0; i < (2 * n); i++) {
            for (int j = 0; j < (2 * n); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        
        System.out.println(matrix.length);

    }
    
    public static int flipMatrix(int matrix[][]){
        for (int i = 0; i < matrix.length; i++) {
            int max = 0;
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] > max && j > matrix.length / 2){
                    int flipcol = i;
                }
            }
            
        }
        return 0;
    }
}
