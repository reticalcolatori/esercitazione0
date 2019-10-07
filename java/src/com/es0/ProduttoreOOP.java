package com.es0;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProduttoreOOP {

	private int ch = -1;
	private String path;
	private InputStream inputStream;
	
	public ProduttoreOOP(String path)
	{
		this(System.in, path);
	}
	
	public ProduttoreOOP(InputStream inputStream, String path)
	{
		this.inputStream = inputStream;
		this.path = path;
	}
	
	public void doThings(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));	
		
		try (FileWriter writer = new FileWriter(path)){
			//Faccio in modo di leggere da tastiera (System.in) finché non ricevo CRTL+D (CRTL+Z)
			while((ch = reader.read()) != -1) writer.write((char)ch);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		//Dato che quando ricevo EOF, lo stream è chiuso non ha senso fare la close.
		//Però anche se la faccio, non fa nulla
		reader.close();
	}
	
	
	public static void main(String[] args){
		//Controllo argomenti
		if(args.length != 1){
			System.out.println("Utilizzo: produttore <filename>");
			System.exit(0);
		}
		
		ProduttoreOOP prod = new ProduttoreOOP(args[0]);

		prod.doThings();
	}
	
}
