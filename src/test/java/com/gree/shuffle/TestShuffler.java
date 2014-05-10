package com.gree.shuffle;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.gree.transform.TransformerException;

public class TestShuffler {

	private Shuffler shuffler;
	private String sampleText;
	private InputStream input;
	private OutputStream output;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		shuffler = new Shuffler();
		sampleText = "test";
		input = new ByteArrayInputStream(sampleText.getBytes(Charset
				.defaultCharset()));
		output = new ByteArrayOutputStream();
	}

	@Test
	public void shouldShuffle() throws ShufflerException, TransformerException {
		String[] commands = { "H", "V", "-15", "5" };
		shuffler.shuffle(input, output, commands);
	}
}
