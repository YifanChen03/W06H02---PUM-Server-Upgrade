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
		if (top == mem.length - 1) {
			if (next == null) {
				this.setNext(new Stack(mem.length * 2));
				next.push(n);
			} else {
				next.push(n);
			}
		} else {
			//Stoppbedingung falls rb einen freien Platz hat, top verschieben
			top++;
			mem[top] = n;
		}
	}

	public int top() {
		if (top == -1 && next == null) {
			return Integer.MIN_VALUE;
		}
		if (next == null) {
			return mem[top];
		} else {
			return next.top();
		}
	}

	public int pop() {
		//falls nächstes ist null für ersten stack
		if (next == null) {
			//falls erster stack leer
			if (top == -1) {
				return Integer.MIN_VALUE;
			} else {
				top = -1;
				return mem[0];
			}
		}
		//falls übernächster == null
		if (next.getNext() == null) {
			if (next.getTop() == 0) {
				int temp = next.getMem()[0];
				next.setTop(-1);
				this.setNext(null);
				return temp;
			} else {
				int temp = next.getMem()[next.getTop()];
				next.setTop(next.getTop() - 1);
				return temp;
			}
		}

		return next.pop();
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
