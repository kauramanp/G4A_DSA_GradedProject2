package skewedTree;

class Logics {
	private Node node;
	Node prevNode = null;
	Node headNode = null;

	void convertTree(Node root) {

		if (root == null) {
			return;
		}

		convertTree(root.left);

		Node rightNode = root.right;
		Node leftNode = root.left;

		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		convertTree(rightNode);
	}

	// Function to print the tree values
	void printTreeValues(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.value + " ");
		printTreeValues(root.right);
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
}