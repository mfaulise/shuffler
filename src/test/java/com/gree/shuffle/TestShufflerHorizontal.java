package com.gree.shuffle;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.gree.transform.TransformerException;

public class TestShufflerHorizontal {

	private Shuffler shuffler;
	private ByteArrayOutputStream output;

	@Before
	public void setUp() throws Exception {
		shuffler = new Shuffler();
		output = new ByteArrayOutputStream();
	}

	@Test
	public void shouldShuffleHorizontally() throws ShufflerException,
			IOException, TransformerException {
		shuffler.shuffle(Utils.getInput("/simple_input.txt"), output,
				new String[] { "H" });
		String results = output.toString(Utils.ENCODING);
		assertEquals(Utils.getFileContents("/simple_output_h.txt"), results);
	}
}
