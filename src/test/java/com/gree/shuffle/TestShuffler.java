package com.gree.shuffle;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;

import org.junit.Before;
import org.junit.Test;

import com.gree.commands.Commands;
import com.gree.util.Utils;

public class TestShuffler {

	private Shuffler shuffler;
	private ByteArrayOutputStream output;

	@Before
	public void setUp() throws Exception {
		shuffler = new Shuffler();
		output = new ByteArrayOutputStream();
	}

	@Test
	public void shouldShuffle() throws Exception {
		String[] commands = Commands.load("/tests/sample/commands.txt");
		shuffler.shuffle(Utils.getInput("/tests/sample/input.txt"), output,
				commands);
		String results = output.toString(Utils.ENCODING);
		assertEquals(Utils.getFileContents("/tests/sample/output.txt"), results);
	}
}
