package BST_A2;

public class BST implements BST_Interface {

	public BST_Node root;
	int size;

	public BST() {
		size = 0;
		root = null;

	}

	@Override
	public boolean insert(String s) {
		// TODO Auto-generated method stub

		if (size == 0 || root == null) {
			root = new BST_Node(s);
			size++;
			return true;

		}

		if (root.containsNode(s)) {
			return false;
		}

		size++;
		return root.insertNode(s);
	}

	@Override
	public boolean remove(String s) {
		// TODO Auto-generated method stub

		if (size == 0) {
			return false;
		}

		if (!root.containsNode(s)) {
			return false;
		}

		size--;
		return root.removeNode(s);
	}

	@Override
	public String findMin() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return null;
		}
		return root.findMin().data;
	}

	@Override
	public String findMax() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return null;
		}
		return root.findMax().data;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(String s) {
		// TODO Auto-generated method stub

		if (root.data == s) {
			return true;
		}

		if (size == 0) {
			return false;
		}
		
		if (root != null) {
			return root.containsNode(s);
		}
		
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		if (size == 0 || root == null) {
			return -1;
		}
		return root.getHeight();
	}

	@Override
	public BST_Node getRoot() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return null;
		}
		return root;
	}

}
