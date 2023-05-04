package com.learnquest.demos;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class GenericStackImpl<E> implements Stack<E> {
		Deque<E> stack;
		java.util.Stack<E> legacyStack;
		
		public GenericStackImpl() {
			switch (new java.util.Random().nextInt(5)) // Randomly pick an implementation
			{
			case 0:
				stack = new LinkedList<E>();
				break;

			case 1:
				stack = new ArrayDeque<E>();
				break;

			case 2:
				stack = new ConcurrentLinkedDeque<E>();
				break;

			case 3:
				stack = new LinkedBlockingDeque<E>();
				break;

			default:
				legacyStack = new java.util.Stack<E>();
			}
	
			System.out.printf("Using %s as the Stack<E> implementation\n", (stack != null ? stack : legacyStack).getClass().getName());
		}
				
		@Override
		public void push(E element) {
			if (stack != null) stack.push(element);
			else legacyStack.push(element);
		}

		@Override
		public E pop() {
			return stack != null ? stack.pop() : legacyStack.pop();
		}
	}
