package BST_A2;

public class BST_Node {

	String data;
	BST_Node left;
	BST_Node right;

	BST_Node(String data){ this.data=data; }

	// --- used for testing  ----------------------------------------------
	//
	// leave these 3 methods in, as is

	public String getData(){ return data; }
	public BST_Node getLeft(){ return left; }
	public BST_Node getRight(){ return right; }

	// --- end used for testing -------------------------------------------


	// --- fill in these methods ------------------------------------------
	//
	// at the moment, they are stubs returning false 
	// or some appropriate "fake" value
	//
	// you make them work properly
	// add the meat of correct implementation logic to them

	// you MAY change the signatures if you wish...
	// make the take more or different parameters
	// have them return different types
	//
	// you may use recursive or iterative implementations


	public boolean containsNode(String s){ 

		BST_Node root = this;

		while (root != null) {
			if (root.data.compareTo(s) == 0) {
				return true;
			} else {
				if (root.data.compareTo(s) < 0) {
					if (root.right == null) {
						return false;
					}
					root = root.right;
				} else {
					if (root.left == null) {
						return false;
					}
					root = root.left;
				}
			}
		}

		return true;
	}

	public boolean insertNode(String s) {

		BST_Node root = this;

		while (root != null) {
			if (root.data.compareTo(s) == 0) {
				return false;
			} else {
				if (root.data.compareTo(s) < 0) {
					if (root.right == null) {
						root.right = new BST_Node(s);
						return true;
					}
					root = root.right;
				} else {
					if (root.left == null) {
						root.left = new BST_Node(s);
						return true;
					}
					root = root.left;
				}
			}
		}

		return true;
	}

	public boolean removeNode(String s){ 

		BST_Node root = this;
		BST_Node parent = this;

		while (root.data.compareTo(s) != 0) {
			if (root.data.compareTo(s) < 0) {
				if (root.right.data.compareTo(s) == 0) {
					root = root.right;
				} else {
					parent = parent.right;
					root = root.right;
				} 
			} else {
				if (root.left.data.compareTo(s) == 0) {
					root = root.left;
				} else {
					root = root.left;
					parent = parent.left;

				}
			}
		}

		if (root.left == null && root.right == null) {
			if (parent.left == root) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (root.left == null && root.right != null) {
			if (parent.left == root) {
				parent.left = root.right;
			} else {
				parent.right = root.right;
			}
		} else if (root.left != null && root.right == null) {
			if (parent.left == root) {
				parent.left = root.left;
			} else {
				parent.right = root.left;
			}
		} else {
			String minRight = root.right.findMin().data;
			root.data = minRight;
			if (root.right.data.compareTo(minRight) == 0) {
				root.right = root.right.right;
			} else {
				root.right.removeNode(minRight);
			}
		}

		return true;
	}

	public BST_Node findMin() { 
		BST_Node root = this;

		while (root.left != null) {
			root = root.left;
		}

		return root; 
	}

	public BST_Node findMax() { 
		BST_Node root = this;

		while (root.right != null) {
			root = root.right;
		}

		return root; 	
	}

	public int getHeight() { 
		int heightLeft = -1;
		int heightRight = -1;
		BST_Node root = this;


		//		while (root != null) {
		//			if (root.right != null) {
		//				height++;
		//				root = root.right;
		//			} else {
		//				if (root.left != null) {
		//					height++;
		//					root = root.left;
		//				}
		//			}
		//		}

		if (root.right != null) {
			heightRight = root.right.getHeight();
		}

		if (root.left != null) {
			heightLeft = root.left.getHeight();
		}

		return Math.max(heightLeft, heightRight) + 1; 
	}

	// --- end fill in these methods --------------------------------------


	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------

	public String toString(){
		return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
				+",Right: "+((this.right!=null)?right.data:"null");
	}
}
