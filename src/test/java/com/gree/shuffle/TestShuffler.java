package com.gree.shuffle;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;

import org.junit.Before;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.gree.commands.Commands;
import com.gree.util.Utils;

@RunWith(Theories.class)
public class TestShuffler {

	private Shuffler shuffler;
	private ByteArrayOutputStream output;

	@Before
	public void setUp() throws Exception {
		shuffler = new Shuffler();
		output = new ByteArrayOutputStream();
	}

	@DataPoints
	public static String[] data() {
		return new String[] { "sample", "vertical", "hor_vert", "complex1",
				"complex2", "complex3" };
	}

	@Theory
	public void shouldShuffle(String path) throws Exception {
		String[] commands = Commands.load(getFile("/tests/" + path + "/commands.txt"));
		shuffler.shuffle(Utils.getInput("/tests/" + path + "/input.txt"),
				output, commands);
		String results = output.toString(Utils.ENCODING);
		assertEquals(Utils.getFileContents(getFile("/tests/" + path + "/output.txt")),
				results);
	}

	private File getFile(String filename) {
		return new File(getClass().getResource(filename).getPath());
	}
}
