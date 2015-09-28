/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

/**
 *
 * @author Kavita
 */
public class D_StringEquality {
    
    public static void main(String[] args) {
        
        String str1="Hello World!"; //created using shorthand
        String str2=new String("Hello World!");
        
        //check if str1==str2? What are you checking here?
        if(str1==str2){
            System.out.println("Same objects");
        }else{
            System.out.println("Different objects");
        }
        
        //check if str1.equals(str2)? What are you checking here?
        if(str1.equals(str2)){
            System.out.println("Same contents");
        }else{
            System.out.println("Different contents");
        }
    }
    
}
