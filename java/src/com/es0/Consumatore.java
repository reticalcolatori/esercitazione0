package com.es0;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Consumatore {


	public static void main(String[] args) {
		FileReader r = null;
		
		//Fare controllo argomenti
		if(args.length != 1){
			System.out.println("Utilizzo: consumatore <inputFileName>");
			System.exit(0);
		}

		try{
			int x; char ch;

			r = new FileReader(args[0]);

			while ( (x = r.read()) >=0)
			{
				ch = (char) x;
				System.out.println(ch);
			}

			r.close();

		}catch(FileNotFoundException ex)
		{
			System.out.println("File non trovato"); System.exit(1);
		}catch(IOException ex){
			System.out.println("Errore di input"); System.exit(2);
		}

	}
	
	
}
