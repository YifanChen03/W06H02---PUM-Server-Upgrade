package pgdp.ds;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stack {
	private Stack next;
	private final int[] mem;
	private int top;

	public Stack(int capacity) {
		next = null;
		mem = new int[capacity];
		top = -1;
	}

	// TODO implement missing methods
	public void push (int n) {
		if (mem.length + top < 0) {
			if (next == null) {
				this.setNext(new Stack(mem.length * 2));
			} else {
				this.getNext().push(n);
			}
		} else {
			//Stoppbedingung falls rb einen freien Platz hat
			mem[mem.length + top] = n;
			top--;
		}
	}

	public int top() {
		if (this == null && next == null) {
			return Integer.MIN_VALUE;
		}
		if (next == null) {
			return top;
		} else {
			return this.getNext().top();
		}
	}

	public int pop() {
		return Integer.MIN_VALUE;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("{\ncapacity = ").append(mem.length).append(",\n");
		sb.append("mem = [")
				.append(IntStream.range(0, top + 1).mapToObj(x -> "" + mem[x]).collect(Collectors.joining(", ")))
				.append("],\n");
		sb.append("next = ").append(next == null ? "null" : "\n" + next.toString()).append("\n}\n");
		return sb.toString();
	}

	//Getter und Setter

	public Stack getNext() {
		return next;
	}

	public void setNext(Stack next) {
		this.next = next;
	}

	public int[] getMem() {
		return mem;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}
}
