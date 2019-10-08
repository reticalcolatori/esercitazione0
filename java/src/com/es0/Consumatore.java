package com.es0;

import java.io.*;

public class Consumatore {

    //java Consumatore  filterprefix  fileName.txt

    public static void main(String[] args) {

        //Il sistema deve funzionare sia con reidirezione sia con due argomenti.
        //Se reidirezione allora ho un solo argomento e piglio i dati da stdin.
        //Altrimenti leggo da file.

		InputStreamReader myStream = null;

        if (args.length == 1) {
        	//java Consumatore prefixstring < fileName.txt
            //Piglio lo stream da stdin.
			myStream = new InputStreamReader(System.in);
        } else if (args.length == 2) {
        	//
            //Piglio lo stream dal file.
			try {
				myStream = new FileReader(args[1]);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.exit(2);
			}
		} else {
            System.out.println("Usage: 	java Consumatore  filterprefix  fileName.txt");
			System.out.println("Usage: 	java Consumatore  filterprefix  < fileName.txt");
            System.exit(0);
        }

		try {
			int ch;
			while((ch = myStream.read()) != -1) {
				if(args[0].indexOf(ch) < 0)
					System.out.print((char)ch);
			}
			myStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

    }

}
