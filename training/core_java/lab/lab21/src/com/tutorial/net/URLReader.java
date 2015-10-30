package com.tutorial.net;

import java.net.*;
import java.io.*;

public class URLReader {
    public static void main(String[] args) throws Exception {

        URL oracle = new URL("http://www.oracle.com/");
		//url.openStream() is same as url.openConnection().getInputStream();
        BufferedReader in = new BufferedReader(
		new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();


		//Using URLConnection
		//URL oracle = new URL("http://www.oracle.com/");		
		URLConnection yc = oracle.openConnection();
        //BufferedReader 
        in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
        //String inputLine;
        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();		
	}
}