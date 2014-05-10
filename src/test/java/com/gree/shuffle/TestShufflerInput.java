package com.gree.shuffle;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestShufflerInput {

	private Shuffler shuffler;
	private OutputStream output;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		shuffler = new Shuffler();
		output = new ByteArrayOutputStream();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldShuffle() throws ShufflerException, FileNotFoundException {
		shuffler.shuffle(getInput("/simple_input.txt"), output,
				new String[] { "H" });
	}

	@Test
	public void shouldNotAcceptInvalidCommands() throws ShufflerException,
			FileNotFoundException {
		thrown.expect(ShufflerException.class);
		thrown.expectMessage("Input is empty");
		shuffler.shuffle(getInput("/empty_input.txt"), output,
				new String[] { "H" });
	}

	private InputStream getInput(String filename) throws FileNotFoundException {
		return this.getClass().getResourceAsStream(filename);
	}
}
