package com.zerokikr.tutorial.leetcode;

import java.util.Stack;

/*	20. Valid Parentheses
 * 
 *	Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 *	determine if the input string is valid.

	An input string is valid if:

	Open brackets must be closed by the same type of brackets.
	Open brackets must be closed in the correct order.
 * 
 * */

public class LeetCode20 {

	public static void main(String[] args) {
		System.out.println(isValid("([}}])"));
	}

	public static boolean isValid(String s) {

		if (s.length() % 2 != 0) { // если строка состоит из закрытых скобок, то кол-во символов в ней четное
			return false;
		}

		char[] chars = s.toCharArray();

		Stack<Character> stack = new Stack<Character>();

		for (char c : chars) {
			if (c == '(' || c == '{' || c == '[') { // проходим по массиву и загоняем в stack все открывающие скобки
				stack.push(c);
			} else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') { // проходим по массиву и удаляем из stack
																				// открывающие скобки, если встречаем в
																				// массиве такие же закрывающие
				stack.pop();
			} else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') { // проходим по массиву и удаляем из stack
																				// открывающие скобки, если встречаем в
																				// массиве такие же закрывающие
				stack.pop();
			} else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') { // проходим по массиву и удаляем из stack
																				// открывающие скобки, если встречаем в
																				// массиве такие же закрывающие
				stack.pop();
			} else {
				stack.push(c);
			}
		}

		return stack.isEmpty(); // возвращаем true если stack пустой (значит все пары скобок удалены из stack и строка s подходящая)

	}

}
