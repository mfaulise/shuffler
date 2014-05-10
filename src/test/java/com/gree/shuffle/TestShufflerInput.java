package com.gree.shuffle;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.gree.transform.TransformerException;

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

	@Test
	public void shouldParseInput() throws ShufflerException,
			FileNotFoundException, TransformerException {
		shuffler.shuffle(getInput("/simple_input.txt"), output,
				new String[] { "H" });
	}

	@Test
	public void shouldNotAcceptEmptyInput() throws ShufflerException,
			FileNotFoundException, TransformerException {
		thrown.expect(ShufflerException.class);
		thrown.expectMessage("Input is empty");
		shuffler.shuffle(getInput("/empty_input.txt"), output,
				new String[] { "H" });
	}

	@Test
	public void shouldNotAcceptInputWithVaryingLineLengths()
			throws ShufflerException, FileNotFoundException,
			TransformerException {
		thrown.expect(ShufflerException.class);
		thrown.expectMessage("Input lines are of varying length");
		shuffler.shuffle(getInput("/invalid_line_input.txt"), output,
				new String[] { "H" });
	}

	private InputStream getInput(String filename) throws FileNotFoundException {
		return this.getClass().getResourceAsStream(filename);
	}
}
