package com.gree.shuffle;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import com.gree.util.Utils;

public class TestShufflerVertical {

	private Shuffler shuffler;
	private ByteArrayOutputStream output;

	@Before
	public void setUp() throws Exception {
		shuffler = new Shuffler();
		output = new ByteArrayOutputStream();
	}

	@Test
	public void shouldShuffleVertically() throws Exception {
		InputStream input = Utils.getInput("/simple_input.txt");
		shuffler.shuffle(input, output, new String[] { "V" });
		String results = output.toString(Utils.ENCODING);
		File file = Utils.getFile("/simple_output_v.txt");
		assertEquals(Utils.getFileContents(file), results);
	}
}
