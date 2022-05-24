package com.deustocine.app.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCineException {

	@Test
	public void test() {
		CineException exception = new CineException("Error");
		assertTrue(exception.getMessage().contentEquals("Error"));
	}

}
