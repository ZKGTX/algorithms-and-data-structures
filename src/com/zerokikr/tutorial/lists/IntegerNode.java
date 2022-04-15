package com.zerokikr.tutorial.lists;

import java.util.Objects;

public class IntegerNode {
	
	private Integer number;
	private IntegerNode next;
	
	public IntegerNode(Integer number) {
		this.number = number;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public IntegerNode getNext() {
		return next;
	}

	public void setNext(IntegerNode next) {
		this.next = next;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntegerNode other = (IntegerNode) obj;
		return Objects.equals(number, other.number);
	}

	@Override
	public String toString() {
		return "IntegerNode [number=" + number + "]";
	}
	
	

}
