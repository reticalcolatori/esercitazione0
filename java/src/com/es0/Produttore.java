package com.es0;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Produttore {

	//Produttore <fileDaScrivere>
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage: Produttore <FileDaScrivere>");
			System.exit(0);
		}
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		FileWriter writer;
		int ch;
		
		try {
			writer = new FileWriter(args[0]);
			
			while((ch = in.read()) != -1) //se leggo -1 ho raggiunto EOF
				writer.write(ch);
			
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}

}
