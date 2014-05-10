package com.gree.shuffle;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestShuffler {

	private Shuffler shuffler;
	private String sampleText;
	private InputStream input;
	private OutputStream output;

	@Rule
	public ExpectedException  thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		shuffler = new Shuffler();
		sampleText = "";
		input = new ByteArrayInputStream(sampleText.getBytes(Charset.defaultCharset()));
		output = new ByteArrayOutputStream();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldShuffle() throws ShufflerException {
		String[] commands = {"H", "V", "-15", "5"};
		shuffler.shuffle(input, output, commands);
	}

	@Test
	public void shouldNotAcceptInvalidCommands() throws ShufflerException {
		thrown.expect(ShufflerException.class);
		thrown.expectMessage("Unexpected command: W");
		shuffler.shuffle(input, output, new String[] {"H", "V", "W"});
	}
}
