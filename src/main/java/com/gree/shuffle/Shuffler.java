package com.gree.shuffle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shuffler {

	public static final String[] VALID_COMMANDS = new String[] { "H", "V" };
	private List<String> lineList;

	public static void main(String[] args) {
	}

	public void shuffle(InputStream input, OutputStream output,
			String[] commands) throws ShufflerException {
		validateCommands(commands);
		parseInput(input);
		if (!validateLines(lineList)) {
			throw new ShufflerException("Input is empty");
		}
	}

	private void validateCommands(String[] commands) throws ShufflerException {
		for (int i = 0; i < commands.length; i++) {
			if (Arrays.asList(VALID_COMMANDS).contains(
					commands[i].toUpperCase())) {
				continue;
			} else if (!isInteger(commands[i])) {
				throw new ShufflerException("Unexpected command: "
						+ commands[i]);
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

	private void parseInput(InputStream input) throws ShufflerException {
		Reader reader = new InputStreamReader(input);
		BufferedReader br = new BufferedReader(reader);
		try {
			lineList = new ArrayList<String>();
			String line = br.readLine();

			while (line != null) {
				lineList.add(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			throw new ShufflerException("IOException: " + e.getMessage());
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				throw new ShufflerException("Error closing file");
			}
		}
	}

	private boolean validateLines(List<String> lines) throws ShufflerException {
		return (lines.size() > 0);
	}
}
