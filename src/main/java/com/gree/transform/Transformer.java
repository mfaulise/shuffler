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
			if (commands[i].equalsIgnoreCase("H")) {
				result = transformHorizontally(result, bounds);
			} else if (commands[i].equalsIgnoreCase("V")) {
				result = transformVertically(result, bounds);
			} else {
				result = transformOffset(result, bounds,
						Integer.parseInt(commands[i]));
			}
		}
		return result;
	}

	private Point transformHorizontally(Point start, Rectangle bounds) {
		return new Point(bounds.width - start.x - 1, start.y);
	}

	private Point transformVertically(Point start, Rectangle bounds) {
		return new Point(start.x, bounds.height - start.y - 1);
	}

	private Point transformOffset(Point start, Rectangle bounds, int offset) {
		int newY = positive_mod(start.y
				+ (int) ((start.x + offset) / bounds.width), bounds.height);
		int newX = (start.x + offset) % bounds.width;
		if (newX < 0) {
			newX += bounds.width;
			newY = positive_mod(newY - 1, bounds.height);
		}
		return new Point(newX, newY);
	}

	private int positive_mod(int factor, int mod) {
		int val = factor % mod;
		if (val < 0) {
			val += mod;
		}
		return val;
	}
}
