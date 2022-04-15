 package com.zerokikr.tutorial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.zerokikr.tutorial.leetcode.LeetCode20;

class LeetCode20Test {

	@Test
	void testIsValid() {
		assertEquals(false, LeetCode20.isValid("[](){{"));
	}
 
	@Test
	void testEmptyString() {
		assertEquals(true, LeetCode20.isValid(""));
	}
	
	
	
}
