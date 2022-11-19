package floor;

import java.util.Stack;

public class StackClass {
	Stack<Integer> tempList = new Stack<Integer>();
	int lastCreatedFloor = -1;

	public void setFloors(Stack<Integer> stack, int floors) {
		Boolean isBottomSet = false;
		if (stack.isEmpty() == false) {
			int i = 0;
			while(stack.isEmpty() == false) {
				System.out.println("Day : " + (i + 1));
			
				if(stack.firstElement()  == floors && isBottomSet == false) {
					isBottomSet = true;
					tempList.push(stack.firstElement());
					stack.remove(stack.firstElement());
					if (tempList.isEmpty() == false) {
						printFloors(tempList, floors);
						tempList.clear();
					}
				}else  {
					tempList.push(stack.firstElement());
						if(stack.firstElement() == (lastCreatedFloor-1)) {
							printFloors(tempList, floors);
							tempList.clear();
						}
					stack.remove(stack.firstElement());
				}
				i++;
			}
		}
	}
	
	public void printFloors(Stack<Integer> tempList, int floors) {
		Stack<Integer> sorted = sortstack(tempList);
		while(sorted.isEmpty() == false) {
			 if((lastCreatedFloor != -1 && lastCreatedFloor ==  (sorted.lastElement() + 1)) || sorted.lastElement() == floors)
			{
				System.out.println(sorted.lastElement());
				lastCreatedFloor = sorted.lastElement();
				sorted.pop();
				if(tempList.isEmpty() == false)
					tempList.remove(lastCreatedFloor);
			}else if(lastCreatedFloor !=  (sorted.lastElement() + 1)) {
				break;
			}

		}
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
