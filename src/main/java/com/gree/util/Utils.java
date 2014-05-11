package com.gree.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;

public class Utils {

	public static String ENCODING = "UTF-8";

	public static InputStream getInput(String filename)
			throws FileNotFoundException {
		return Utils.class.getResourceAsStream(filename);
	}

	public static String getFileContents(File file) throws IOException{
		StringWriter writer = new StringWriter();
		FileInputStream input = null;
		try {
			input = new FileInputStream(file);
			IOUtils.copy(input, writer, ENCODING);
		} finally {
			try {
				if (input != null)
					input.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return writer.toString();
	}
}
