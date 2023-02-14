/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pga
 */
class Solution {

    static ArrayList answer = new ArrayList();
    public int solution(int X) {
        // write your code in Java SE 8
        int temp = X;
        ArrayList<Integer> arr = new ArrayList<Integer>();

        do {
            arr.add(temp % 10);
            temp /= 10;
        } while (temp > 0);

        Collections.reverse(arr);

        ArrayList<Integer> avg = new ArrayList<Integer>();

        for (int i = 0; i < arr.size() - 1; i++) {

            double n = ((arr.get(i) + arr.get(i + 1)) / 2.0);
            
            int ans = (int) Math.ceil(n);
            
            if (ans > arr.get(i)) {
                answer.add(i,ans);
                for(int x = i+2; x < arr.size(); x++){
                    answer.add(arr.get(x));
                }
                break;
            } else {
                answer.add(arr.get(i));
            }
        }

        System.out.println(answer);
        

        return 0;
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        System.out.println(x);

        Solution obj = new Solution();
        obj.solution(x);
    }
}
