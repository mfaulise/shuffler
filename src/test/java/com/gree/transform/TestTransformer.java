package com.gree.transform;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.awt.Rectangle;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestTransformer {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void test() throws TransformerException {
		new Transformer(new String[] {});
	}

	@Test
	public void shouldNotAcceptInvalidCommands() throws TransformerException {
		thrown.expect(TransformerException.class);
		thrown.expectMessage("Unexpected command: W");
		new Transformer(new String[] { "H", "V", "W" });
	}

	@Test
	public void shouldNotAcceptFloatCommands() throws TransformerException {
		thrown.expect(TransformerException.class);
		thrown.expectMessage("Unexpected command: 5.7");
		new Transformer(new String[] { "5.7" });
	}

	@Test
	public void shouldTransformHorizontally() throws TransformerException {
		Transformer tf = new Transformer(new String[] { "H" });
		Point pt = tf.transform(new Point(0,0), new Rectangle(4, 2));
		assertEquals(new Point(3,0), pt);

		pt = tf.transform(new Point(2,2), new Rectangle(4, 2));
		assertEquals(new Point(1,2), pt);

		pt = tf.transform(new Point(17,10), new Rectangle(20, 20));
		assertEquals(new Point(2,10), pt);
	}

}
