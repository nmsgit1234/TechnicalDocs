package com.tutorial.net;

import java.net.InetAddress;

public class InetAddressTest{

	public static void main(String args[]) throws Exception{
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address);
		
		address = InetAddress.getByName("www.google.com");
		System.out.println("The InetAddress of www.google.com is " + address);
		System.out.println("The getHostAddress() of www.google.com is " + address.getHostAddress());
		System.out.println("The getHostName() of www.google.com is " + address.getHostName());
		
		System.out.println("Is InetAddress of www.google.com is multicast address?  " + address.isMulticastAddress());
		
		InetAddress[] allAddresses = InetAddress.getAllByName("www.yahoo.com");
		for(InetAddress inetAddress:allAddresses){
			System.out.println(inetAddress);
		}
	}
}