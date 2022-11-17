package floor;

import java.util.Stack;

public class StackClass {

	public void setFloors(Stack<Integer> stack, int floors) {
		Stack<Integer> tempList = new Stack<Integer>();
		Boolean isBottomSet = false;
		if (stack.isEmpty() == false) {
			for (int i = 0; i < floors; i++) {
				System.out.println("Day : " + (i + 1));
				int biggest = findBiggest(stack);
				System.out.println("biggest " + biggest);
				if (biggest == stack.elementAt(i)) {
					System.out.print(biggest);
					isBottomSet = true;
					if (tempList.isEmpty() == false) {
						Stack<Integer> sorted = sortstack(tempList);
						for(int k = 0; k<sorted.size(); k++) {
							System.out.print(" "+sorted.elementAt(k));
						}
						tempList.clear();
					}
				} else if (isBottomSet == true && stack.elementAt(i) < stack.elementAt(i - 1)) {
					continue;
				} else {
					tempList.add(stack.elementAt(i));
				}
			}
		}
	}

	public int findBiggest(Stack<Integer> stack) {
		int biggest = stack.firstElement();
		for (int i = 0; i < stack.size(); i++) {
			for (int j = i; j < stack.size(); j++)
				if (biggest < stack.elementAt(j)) {
					biggest = stack.elementAt(j);
				}
		}
		return biggest;

	}

	public static Stack<Integer> sortstack(Stack<Integer> input) {
		Stack<Integer> tmpStack = new Stack<Integer>();
		while (!input.isEmpty()) {
			int tmp = input.pop();

			while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
				input.push(tmpStack.pop());
			}

			tmpStack.push(tmp);
		}
		return tmpStack;
	}

}
