package com.gree.commands;

import java.io.File;
import java.io.IOException;

import com.gree.util.Utils;

public class Commands {

	public static String[] load(File file) throws IOException {
		String commandString = Utils.getFileContents(file);
		String[] commands = commandString.split("\\s*,\\s*");
		for (int i = 0; i < commands.length; i++) {
			commands[i] = commands[i].trim();
		}
		return commands;
	}

}
