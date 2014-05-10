package com.gree.shuffle;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestShufflerHorizontal {

	private static String ENCODING = "UTF-8";
	
	private Shuffler shuffler;
	private ByteArrayOutputStream output;

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
	public void shouldShuffleHorizontally() throws ShufflerException,
			IOException {
		shuffler.shuffle(getInput("/simple_input.txt"), output,
				new String[] { "H" });
		String results = output.toString(ENCODING);
		assertEquals(getFileContents("/simple_output_h.txt"), results);
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

	private String getFileContents(String filename) throws FileNotFoundException, IOException {
		StringWriter writer = new StringWriter();
		IOUtils.copy(getInput(filename), writer, ENCODING);
		return writer.toString();
	}
}
