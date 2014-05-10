package com.gree.shuffle;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestShuffler {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShufflerShuffles() {
		Shuffler shuffler = new Shuffler();
		String sampleText = "";
		InputStream input = new ByteArrayInputStream(sampleText.getBytes(Charset.defaultCharset()));
		OutputStream output = new ByteArrayOutputStream();
		String[] commands = {"H", "V", "-15", "5"};
		shuffler.shuffle(input, output, commands);
	}

}
