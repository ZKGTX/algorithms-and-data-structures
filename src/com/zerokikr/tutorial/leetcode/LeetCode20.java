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

		if (s.length() % 2 != 0) { // ���� ������ ������� �� �������� ������, �� ���-�� �������� � ��� ������
			return false;
		}

		char[] chars = s.toCharArray();

		Stack<Character> stack = new Stack<Character>();

		for (char c : chars) {
			if (c == '(' || c == '{' || c == '[') { // �������� �� ������� � �������� � stack ��� ����������� ������
				stack.push(c);
			} else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') { // �������� �� ������� � ������� �� stack
																				// ����������� ������, ���� ��������� �
																				// ������� ����� �� �����������
				stack.pop();
			} else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') { // �������� �� ������� � ������� �� stack
																				// ����������� ������, ���� ��������� �
																				// ������� ����� �� �����������
				stack.pop();
			} else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') { // �������� �� ������� � ������� �� stack
																				// ����������� ������, ���� ��������� �
																				// ������� ����� �� �����������
				stack.pop();
			} else {
				stack.push(c);
			}
		}

		return stack.isEmpty(); // ���������� true ���� stack ������ (������ ��� ���� ������ ������� �� stack � ������ s ����������)

	}

}
