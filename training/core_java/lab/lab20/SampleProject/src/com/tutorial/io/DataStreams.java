package com.tutorial.io;
import java.io.*;


public class DataStreams{

	public static void main(String args[]){
		String dataFile = "invoicedata";
		double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
		int[] units = { 12, 8, 13, 29, 50 };
		final String[] descs = {
			"Java T-shirt",
			"Java Mug",
			"Duke Juggling Dolls",
			"Java Pin",
			"Java Key Chain"
		};	
		DataOutputStream out = null;
		try{

		out = new DataOutputStream(new BufferedOutputStream(
					  new FileOutputStream(dataFile)));
			for (int i = 0; i < prices.length; i ++) {
				out.writeDouble(prices[i]);
				out.writeInt(units[i]);
				out.writeUTF(descs[i]);
			}
		} catch(Exception ex){
			ex.printStackTrace();
		} finally {
			try{
				if (out != null) out.close();
			}
			catch(Exception e){
			}			}
		double price;
		int unit;
		String desc;
		double total = 0.0;
		DataInputStream in= null;
		try {
			in = new DataInputStream(new
					BufferedInputStream(new FileInputStream(dataFile)));

			while (true) {
				price = in.readDouble();
				unit = in.readInt();
				desc = in.readUTF();
				System.out.format("You ordered %d" + " units of %s at $%.2f%n",
					unit, desc, price);
				total += unit * price;
			}
		} catch (EOFException e) {
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		finally {
			try{
				if (out != null) out.close();
			}
			catch(Exception e){
			}	
		}
}
}