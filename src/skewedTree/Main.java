package skewedTree;

public class Main {
	public static void main(String a[]) {
		Logics tree = new Logics();
		tree.setNode(new Node(50));
		tree.getNode().left = new Node(30);
		tree.getNode().left.left = new Node(10);

		tree.getNode().right = new Node(60);
		tree.getNode().right.left = new Node(55);

		tree.convertTree(tree.getNode());
		tree.printTreeValues(tree.headNode);
	}

}
