package model;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Consumatore {

	//java Consumatore  filterprefix  fileName.txt
	
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Usage: 	java Consumatore  filterprefix  fileName.txt");
			System.exit(0);
		}
		
		FileReader reader = null;
		
		try {
			reader = new FileReader(args[1]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			int ch;
			while((ch = reader.read()) != -1) {
				if(args[0].indexOf(ch) < 0)
					System.out.print((char)ch);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
