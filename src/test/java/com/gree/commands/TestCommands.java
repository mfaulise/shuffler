package com.gree.commands;

import static org.junit.Assert.assertArrayEquals;

import java.io.File;

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
		String[] commands = Commands.load(getFile("/commands/simple.txt"));
		assertArrayEquals(new String[]{"H", "V", "5"}, commands);
	}

	@Test
	public void shouldIgnoreWhiteSpace() throws Exception {
		String[] commands = Commands.load(getFile("/commands/white_space.txt"));
		assertArrayEquals(new String[]{"H", "V", "5"}, commands);
	}

	@Test
	public void shouldHandleSingleCommand() throws Exception {
		String[] commands = Commands.load(getFile("/commands/single_command.txt"));
		assertArrayEquals(new String[]{"H"}, commands);
	}

	private File getFile(String filename) {
		return new File(getClass().getResource(filename).getPath());
	}
}
