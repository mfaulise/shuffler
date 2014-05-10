package com.gree.transform;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Arrays;

public class Transformer {

	private static final String[] VALID_COMMANDS = new String[] { "H", "V" };

	private String[] commands;

	public Transformer(String[] commands) throws TransformerException {
		validateCommands(commands);
		this.commands = commands;
	}

	private void validateCommands(String[] commands) throws TransformerException {
		for (int i = 0; i < commands.length; i++) {
			if (Arrays.asList(VALID_COMMANDS).contains(
					commands[i].toUpperCase())) {
				continue;
			} else if (!isInteger(commands[i])) {
				throw new TransformerException("Unexpected command: "
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

	public Point transform(Point start, Rectangle bounds) {
		Point result = new Point(start.x, start.y);
		for (int i = 0; i < commands.length; i++) {
			if( commands[i].toUpperCase() == "H") {
				result = transformHorizontally(result, bounds);
			}
		}
		return result;
	}

	private Point transformHorizontally(Point start, Rectangle bounds) {
		return new Point(bounds.width - start.x -1, start.y);
	}

}