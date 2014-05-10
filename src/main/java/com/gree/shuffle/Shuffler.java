package com.gree.shuffle;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class Shuffler {

	public static final String[] VALID_COMMANDS = new String[] { "H", "V" };

	public static void main(String[] args) {
	}

	public void shuffle(InputStream input, OutputStream output,
			String[] commands) throws ShufflerException {
		validateCommands(commands);
	}

	private void validateCommands(String[] commands) throws ShufflerException {
		for (int i = 0; i < commands.length; i++) {
			if (Arrays.asList(VALID_COMMANDS).contains(
					commands[i].toUpperCase())) {
				continue;
			}
			else if ( ! isInteger(commands[i])) {
				throw new ShufflerException("Unexpected command: " + commands[i]);
			}
		}
	}

	private static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
