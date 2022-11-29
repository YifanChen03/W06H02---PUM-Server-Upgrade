package pgdp.ds;

import java.util.Arrays;

public class RingBuffer {

	private int[] mem;
	private int in;
	private int out;
	private int stored;

	RingBuffer(int capacity) {
		mem = new int[capacity];
		in = 0;
		out = 0;
		stored = 0;
	}

	// TODO implement missing methods
	public boolean isEmpty() {
		for (int i = 0; i < mem.length; i++) {
			if (mem[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public boolean isFull() {
		int c = 0;
		for (int i = 0; i < mem.length; i++) {
			if (mem[i] != 0) {
				c++;
			}
		}
		if (c == mem.length) {
			return true;
		}
		return false;
	}

	public boolean put(int n) {
		if (!isFull()) {
			mem[in] = n;
			return true;
		}
		return false;
	}

	public int get() {
		try {
			return mem[out];
		}
		catch(Exception e) {
			return Integer.MAX_VALUE;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("RingBuffer := { capacity = ").append(mem.length).append(", out = ").append(out).append(", in = ")
				.append(in).append(", stored = ").append(stored).append(", mem = ").append(Arrays.toString(mem))
				.append(", buffer = [");
		if (!isEmpty()) {
			if(in >= 0 || in < mem.length) {
				int i = out;
				do {
					sb.append(mem[i]).append(", ");
					i = (i + 1) % mem.length;
				} while (i != in);
				sb.setLength(sb.length() - 2);
			} else {
				sb.append("Error: Field 'in' is <").append(in).append(">, which is out of bounds for an array of length ").append(mem.length);
			}
		}
		sb.append("] }");
		return sb.toString();
	}
}
