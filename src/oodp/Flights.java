/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodp;

import java.util.ArrayList;

/**
 *
 * @author Pushpak
 */
public class Flights {
   final static int k = 0;
    public static void main(String arg[]){
        int[] arr = {900, 902, 904, 906, 908, 910};
        int[] dep = {902, 904, 906, 908, 910, 912};
        int flights = 6;
        int count=1;
        int max=1;
        ArrayList<Integer> waiting = new ArrayList();
        
        
        int current_arrival = arr[1];
        
        for (int i = 0 ; i < flights - 1 ; i++){
            if(current_arrival > dep[i]){
                count--;
                
            }else{
                waiting.add(dep[i]);
            }          
                 
            for (int j = 0; j < waiting.size(); j++) {
                    if(waiting.get(j) < current_arrival){
                    count--;
                    waiting.remove(j);
                }
            }
            
            if(i==0)
                current_arrival = arr[i+2];
            else
                current_arrival = arr[i+1];
            
            if(max < count){
                 max = count;
            }
            count++;
        }   
                     
    System.out.println(max);
    }
    
}
