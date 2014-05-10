package com.gree.shuffle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;

public class Utils {

	public static String ENCODING = "UTF-8";

	public static InputStream getInput(String filename) throws FileNotFoundException {
		return Utils.class.getResourceAsStream(filename);
	}

	public static String getFileContents(String filename) throws FileNotFoundException, IOException {
		StringWriter writer = new StringWriter();
		IOUtils.copy(getInput(filename), writer, ENCODING);
		return writer.toString();
	}
}
