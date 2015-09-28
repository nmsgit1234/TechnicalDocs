package examples;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kavita
 */
public class A_StringCreation {

    public static void main(String[] args) {

        /*--- Example String creation ----*/
        //Create 2 variables s1 and s2 that contain "Hello World!"
        String s1 = "Hello World!"; //shorthand String creation
        String s2 = new String("Hello World!"); //explicitly create a 'new' String object
        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2);

        //Create a new String object with s2
        String s3 = new String(s2); //pass a String into the String constructor
        System.out.println("s3:" + s3);

        //Character array containing 'h','e','l','l','o','.'
        char[] helloArray = {'h', 'e', 'l', 'l', 'o', '.'};
        String s4 = new String(helloArray); //pass char array into String constructor
        System.out.println("s4:" + s4);

        //Bytes of letter A,B,C,D in decimal (http://www.csgnetwork.com/asciiset.html)
        byte[] test = {65, 66, 67, 68};
        String s5 = new String(test); //pass byte array into String constructor
        System.out.println("s5:" + s5);


        /*--- Empty and null initialization ----*/
        String s6 = null; //initialize to null
        System.out.println("s6:" + s6);

        String s7 = ""; //initialize an empty string
        System.out.println("s7:" + s7);

        String s8 = new String(""); //initialize an empty string
        System.out.println("s8:" + s8);

    }

}
