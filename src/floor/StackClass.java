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
				System.out.println("Day : " + (i + 1) +" tempList "+tempList.size());
			
				if(stack.firstElement()  == floors && isBottomSet == false) {
					isBottomSet = true;
					tempList.push(stack.firstElement());
					stack.remove(stack.firstElement());
					if (tempList.isEmpty() == false) {
						printFloors( floors);
					}
				}else  {
				//	System.out.println("stack.firstElement() "+stack.firstElement());
					tempList.push(stack.firstElement());
						if(stack.firstElement() == (lastCreatedFloor-1)) {
							printFloors( floors);
						}
					stack.remove(stack.firstElement());
				}
				i++;
			}
		}
	}
	
	public void printFloors( int floors) {
		System.out.println(" temp list "+tempList.size());
		Stack<Integer> tempList1 = new Stack<Integer>();
		tempList1 = tempList;
		Stack<Integer> sorted = sortstack(tempList);
		tempList = tempList1;
		System.out.println("after sorting temp list "+tempList.size());

		while(sorted.isEmpty() == false) {
			//System.out.println(" sorted.lastElement() "+sorted.lastElement() +" lastCreatedFloor " + lastCreatedFloor + " temp list "+tempList.size());
			 if((lastCreatedFloor != -1 && lastCreatedFloor ==  (sorted.lastElement() + 1)) || sorted.lastElement() == floors)
			{
				System.out.println(sorted.lastElement());
				lastCreatedFloor = sorted.lastElement();
				sorted.pop();
				if(tempList.isEmpty() == false)
					tempList.remove(lastCreatedFloor);
			}else if(lastCreatedFloor !=  (sorted.lastElement() + 1)) {
				break;
			}else {
				System.out.println(sorted.lastElement());
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
