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

public class B_StringPools {

	public static void main(String[] args) {
		
		//Create 3 new variables that contain "Hello Utah!"
		String s1="String pools are efficient!"; //shorthand
                                String s2="String pools are efficient!"; //shorthand
		String s3=new String("String pools are efficient!"); //traditional object construction
		
		//PRINT s1, s2, s3. Are they the same?
		System.out.println("s1:"+s1);
		System.out.println("s2:"+s2);
		System.out.println("s3:"+s3);
	
		
		//1. Does s1 refer to the same object as s2?
		System.out.print("Does s1 refer to the same object as s2 ? ");
		System.out.println(s1==s2);
		
		//2. Does s1 refer to the same object as s3?
		System.out.print("Does s1 refer to the same object as s3 ? ");
		System.out.println(s1==s3);
		
		//3. Does s2 refer to the same object as s3?
		System.out.print("Does s2 refer to the same object as s3 ? ");
		System.out.println(s2==s3);
                
	}

}
