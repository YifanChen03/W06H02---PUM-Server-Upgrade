package pgdp.ds;

public class MultiStack {

	private final Stack stacks;

	public MultiStack() {
		stacks = new Stack(1);
	}

	// TODO implement missing methods
	public void push(int n) {
		stacks.push(n);
	}

	public int top() {
		return stacks.top();
	}

	public int pop() {

		return Integer.MIN_VALUE;
	}
	@Override
	public String toString() {
		return stacks.toString();
	}

}
