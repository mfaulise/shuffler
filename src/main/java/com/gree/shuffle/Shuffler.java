package com.gree.shuffle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
		validateLines(lineList);
		List<String> outputLines = processCommands(commands);
		writeOutput(output, outputLines);
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

	private void validateLines(List<String> lines) throws ShufflerException {
		if (lines.size() == 0) {
			throw new ShufflerException("Input is empty");
		}
		int firstLineLength = lines.get(0).length();
		for (Iterator<String> iter = lines.iterator(); iter.hasNext();) {
			if(iter.next().length() != firstLineLength) {
				throw new ShufflerException("Input lines are of varying length");
			}
		}
	}

	private List<String> processCommands(String[] commands) {
		char[][] output = buildOutputList();
		for (int i = 0; i < lineList.size(); i++) {
			String line = lineList.get(i);
			for (int j = 0; j < line.length(); j++) {
				output[i][line.length() - j - 1] = line.charAt(j);
			}
		}
		return convertOutputListToString(output);
	}

	private char[][] buildOutputList() {
		char[][] output = new char[lineList.size()][];
		for (int i = 0; i < lineList.size(); i++) {
			String line = lineList.get(i);
			output[i] = new char[line.length()];
		}
		return output;
	}

	private List<String> convertOutputListToString(char[][] output) {
		List<String> outputStrings = new ArrayList<String>();
		for (int i = 0; i < output.length; i++) {
			outputStrings.add(new String(output[i]));
		}
		return outputStrings;
	}

	private void writeOutput(OutputStream output, List<String> outputLines) {
		PrintWriter writer = new PrintWriter(output);
		for (Iterator<String> iter = outputLines.iterator(); iter.hasNext();) {
			writer.println(iter.next());
		}
		writer.close();
	}
}
