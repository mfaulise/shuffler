package com.gree.shuffle;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class TestShufflerVertical {
	
	private Shuffler shuffler;
	private ByteArrayOutputStream output;

	@Before
	public void setUp() throws Exception {
		shuffler = new Shuffler();
		output = new ByteArrayOutputStream();
	}

//	TODO re-enable this test after adding the command transformer 
//	@Test
	public void shouldShuffleVertically() throws ShufflerException,
			IOException {
		shuffler.shuffle(Utils.getInput("/simple_input.txt"), output,
				new String[] { "V" });
		String results = output.toString(Utils.ENCODING);
		assertEquals(Utils.getFileContents("/simple_output_v.txt"), results);
	}
}
