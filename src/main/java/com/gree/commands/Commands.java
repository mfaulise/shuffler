package com.gree.commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.gree.util.Utils;

public class Commands {

	public static String[] load(String filename) throws FileNotFoundException, IOException {
		String commandString = Utils.getFileContents(filename);
		String[] commands = commandString.split("\\s*,\\s*");
		for (int i = 0; i < commands.length; i++) {
			commands[i] = commands[i].trim();
		}
		return commands;
	}

}
