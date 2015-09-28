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
public class C_StringMethodsAndConcat {

    public static void main(String[] args) {
        
        //Define variable str of type String, with value 'My String Value'
        String str = "My String Value";
        System.out.println("str value: " + str);

        //Get length of str
        int len = str.length();
        System.out.println("str.length(): " + len);

        //Get uppercase value of str
        String strUppercase = str.toUpperCase();
        System.out.println("str.toUpperCase(): " + strUppercase);

        //Get lowercase value of str
        String strLowercase = str.toLowerCase();
        System.out.println("str.toLowerCase(): " + strLowercase);
        
        //Get char at position 1 from str
        char charAtOne = str.charAt(1); //Should return 'y'
        System.out.println("str.charAt(1): " + charAtOne);
        
        //Concatenate str with 'is Short' 
        String str2="is Short";
        String strConcat=str +" " + str2;
        System.out.println("str + \"is Short\":" + strConcat);
        
        //Concatenate str with 'is Short' and int value of 22
        str2="is Short";
        int val=22;
        
        //concatenate with '+' operator
        strConcat=str +" " + str2 + val;
        System.out.println("str + \"is Short\" + 22:" + strConcat);
        
        //concatenate with concat
        strConcat=str.concat(" ").concat(str2).concat(String.valueOf(val));
        System.out.println("str + \"is Short\" + 22:" + strConcat);

    }

}
