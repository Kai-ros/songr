package com.example.songr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.example.songr.controllers.HomeController.reverseHelper;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SongrApplicationTests
{
	@Test
	public void testReverseHelper()
	{
		String inputMessage = "Some string of words to reverse.";
		assertEquals(
				"reverseHelper() should correctly reverse the order of the words in a given sentence.",
				"reverse. to words of string Some",
				reverseHelper(inputMessage));
	}
}
