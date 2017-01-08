/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodp;

/**
 *
 * @author pga
 */
public class ReverseString {
    public static void main(String arg[]){
        String s= "This is my pen";
        String[] arr = s.split(" ");
        String Ans="";
        for(int i = 0; i < arr.length; i++){
            Ans = arr[i] +" "+ Ans;
            
        }       
        System.out.println(Ans);
    }
    
}
