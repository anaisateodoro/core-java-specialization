package com.learnquest.demos;

public class StackArray<E> implements Stack<E> {
	int tos;
	E[] stack;

	public StackArray() {
		this(10);
	}

	@SuppressWarnings("unchecked")
	public StackArray(int maxdepth) {
		tos = 0;
		stack = (E[]) new Object[maxdepth];
	}

	@Override
	public void push(E element) {
		stack[tos++] = element;
	}

	@Override
	public E pop() {
		// Empty stack returns null, since we have not covered Exception Handling, yet
		return tos > 0 ? stack[--tos] : null;
	}
}
