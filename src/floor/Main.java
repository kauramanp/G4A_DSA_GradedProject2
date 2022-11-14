package floor;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String a[]) {
		Stack<Integer> stack = new Stack<Integer>();
		StackClass stackClass = new StackClass();
		int floors;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the total no of floors in the building");
		floors = sc.nextInt();
		for (int i = 0; i < floors; i++) {
			System.out.println("enter the floor size given on day : " + (i + 1));
			stack.push(sc.nextInt());
		}
		System.out.println("The order of construction is as follows");
		stackClass.setFloors(stack, floors);
	}
}
