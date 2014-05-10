package com.gree.commands;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class TestCommands {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void shouldLoadSimpleCommands() throws Exception {
		String[] commands = Commands.load("/commands/simple.txt");
		assertArrayEquals(new String[]{"H", "V", "5"}, commands);
	}

	@Test
	public void shouldIgnoreWhiteSpace() throws Exception {
		String[] commands = Commands.load("/commands/white_space.txt");
		assertArrayEquals(new String[]{"H", "V", "5"}, commands);
	}

	@Test
	public void shouldHandleSingleCommand() throws Exception {
		String[] commands = Commands.load("/commands/single_command.txt");
		assertArrayEquals(new String[]{"H"}, commands);
	}
}
