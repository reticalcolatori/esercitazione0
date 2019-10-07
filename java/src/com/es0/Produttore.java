package com.es0;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Produttore {
	
	public static void main(String[] args){
		//Controllo argomenti
		if(args.length != 1){
			System.out.println("Utilizzo: produttore <filename>");
			System.exit(0);
		}
        
        //Dato che quando ricevo EOF, lo stream è chiuso non ha senso fare la close.
        //Però anche se la faccio, non fa nulla
        //Quindi uso il try-resource per compattare il codice.
                
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int ch = -1;
		
            try (FileWriter writer = new FileWriter(args[0])){
                //Faccio in modo di leggere da tastiera (System.in) finché non ricevo CRTL+D (CRTL+Z)
                while((ch = reader.read()) != -1) writer.write((char)ch);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(2);
        }
        
		//reader.close();
	}
	
}
