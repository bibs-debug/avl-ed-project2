public class BST<T> {

    protected Node<T> root;

    public BinaryTree(BinaryNode<T> root) {
         this.root = root; 
    }

	public void setRoot(BinaryNode<T> root) { 
        this.root = root; 
    }

    public boolean isEmpty() {
		return root == null;
	}

	public int getDegree() {
		if (isEmpty()) {
			return -1;
		}
		
		return getDegree(root);
	}

    private int getDegree(BinaryNode<T> root) {
		if (root == null || root.isLeaf())
			return 0;
		
		int degree = root.getDegree();
		
		int leftDegree = getDegree(root.getLeft());
		int rightDegree = getDegree(root.getRight());
		return Math.max(degree, Math.max(leftDegree, rightDegree));
	}
	
    public int getHeight() {
		if (isEmpty()) {
			return -1;
		}
		
		return root.getHeight();
	}

    public Node<T> insert(Node node, T key){
        if(node == null){
            return new Node<>(key);
        }

        if(node.getKey().equals(key)){
            return node;
        }
        if(key.compareTo(node.getKey()) < 0){
            node.setLeft(insert(root.getLeft(),key));
        }
        node.setRight(insert(node.getRight(), key));

        return node;
    }

    private Node<T> sucessor(Node<T> node) {
        Node<T> current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    public Node<T> delete (Node<T> node, T key){
        if(node == null){
            return null;
        }
        if (key.compareTo(node.getKey()) < 0) {
            node.setLeft(delete(node.getLeft(), key));
        }
        else if (key.compareTo(node.getKey()) > 0) {
            node.setRight(delete(node.getRight(), key));
        }
        else {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }
            else if (node.getLeft() == null) {
                return node.getRight();  
            } else if (node.getRight() == null) {
                return node.getLeft();  
            }
            else {
                // Encontra o sucessor (o menor valor na subárvore à direita)
                Node<T> successor = minValueNode(node.getRight());
                node.setKey(successor.getKey());  // Substitui o valor do nó a ser deletado pelo sucessor
                node.setRight(delete(node.getRight(), successor.getKey()));  // Deleta o sucessor
            }
        }
    
        return node;
    }
    

    public void inOrderTraversal() {
		inOrderTraversal(root);
	}
	
    private void inOrderTraversal(BinaryNode<T> root) {
		if (root != null) {
			inOrderTraversal(root.getLeft());
			System.out.print(root.getKey() + "  ");
			inOrderTraversal(root.getRight());
		}
	}

    public void preOrderTraversal() {
		preOrderTraversal(root);
	}
	
	private void preOrderTraversal(BinaryNode<T> root) {
		if (root != null) {
			System.out.print(root.getKey() + "  ");
			preOrderTraversal(root.getLeft());
			preOrderTraversal(root.getRight());
		}
	}

    public void postOrderTraversal() {
		postOrderTraversal(root);
	}
	
	private void postOrderTraversal(BinaryNode<T> root) {
		if (root != null) {
			postOrderTraversal(root.getLeft());
			postOrderTraversal(root.getRight());
			System.out.print(root.getKey() + "  ");
		}
	}
}