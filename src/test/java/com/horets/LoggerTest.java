package com.horets;

import org.junit.Test;

import com.horets.util.Logger;


public class LoggerTest {

	@Test
	public void test() {
		Logger logger = Logger.getLogger();
		logger.log("test coding.....");
	}
	
}	
