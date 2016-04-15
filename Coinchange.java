/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinchange;

import java.util.Arrays;

/**
 *
 * @author test1
 */
public class Coinchange {

    public static int Greedy(int[] denom,int total){
         if (total==0)
             return 0;
         for(int i=0;i<4;i++){
             if (denom[i]<=total){
                 total=total-denom[i];
                 break;
             }    
         }
        return Greedy(denom,total)+1;
    }
    
    public static int Dynamic(int[] denom,int total){
        int[] c=new int[total+1];
        
        for (int i=0;i<c.length;i++){
            if (i==0){
                c[0]=0;
                continue;
            }
                
            c[i]=999;
            for (int j=0;j<denom.length;j++){
                if (i>=denom[j] && (1+c[i-denom[j]])<c[i]){
                    c[i]=1+c[i-denom[j]];
                    System.out.println(c[i]);
                }
                    
            }
        }
        return c[total];
    }
    
    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        int[] denom={25,10,5,1};
        int total=30;
        System.out.println("Minimum coins by greedy: "+Greedy(denom,total));
        System.out.println("Minimum coins by dynamic: "+Dynamic(denom,total));
    }
    
}
