package com.gree.shuffle;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.gree.util.Utils;

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
	public void shouldParseInput() throws Exception {
		InputStream input = Utils.getInput("/simple_input.txt");
		shuffler.shuffle(input, output, new String[] { "H" });
	}

	@Test
	public void shouldNotAcceptEmptyInput() throws Exception {
		thrown.expect(ShufflerException.class);
		thrown.expectMessage("Input is empty");
		InputStream input = Utils.getInput("/empty_input.txt");
		shuffler.shuffle(input, output, new String[] { "H" });
	}

	@Test
	public void shouldNotAcceptInputWithVaryingLineLengths() throws Exception {
		thrown.expect(ShufflerException.class);
		thrown.expectMessage("Input lines are of varying length");
		InputStream input = Utils.getInput("/invalid_line_input.txt");
		shuffler.shuffle(input, output, new String[] { "H" });
	}
}
