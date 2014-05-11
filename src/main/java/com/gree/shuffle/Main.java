package com.gree.shuffle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.gree.commands.Commands;

public class Main {

	public static void main(String[] args) {		
		if( args.length != 2 ) {
			System.err.println("Expected 2 arguments; input_file and command_file.");
	        System.exit(1);
		}
		String[] commands = getCommands(args[1]);
		Shuffler shuffler = new Shuffler();
		FileInputStream input = null;
		try {
			File file = new File(args[0]);
			input = new FileInputStream(file);
			shuffler.shuffle(input, System.out, commands);
		} catch (FileNotFoundException e) {
			System.err.println("Could not find input_file; " + args[0]);
	        System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
	        System.exit(1);
		} finally {
			if (input != null ) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	private static String[] getCommands(String commandFile) {
		try {
			return Commands.load(new File(commandFile));
		} catch (IOException e) {
			e.printStackTrace();
	        System.exit(1);
		}
		return null;
	}
}
