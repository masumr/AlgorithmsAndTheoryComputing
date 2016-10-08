import java.util.*;
class CS6085ATolani {
	public static void main(String[] args) {
		BTMethods one = new BTMethods();
		one.createBinaryTree();
		System.out.println();
		System.out.println("Pre Order Travesal");
		one.preOrder(one.root);
		System.out.println();
		System.out.println("height = "+one.height(one.root));
		System.out.print("level Order");
		one.displayTree(one.root);
		System.out.println();
		System.out.println("number of nodes in the tree : "+numberOfNodes(one.root));

	}
	static int numberOfNodes(BTNode root){
		if(root == null)
			return 0;
		else 
			return(numberOfNodes(root.right) + numberOfNodes(root.left) + 1);
	}
	static void largest(BTNode root){
		char currentChar = 'a';
		if(root!=null)
		{
			if(root.element > currentChar)
			{
				currentChar = root.element();
			}
			largest(root.left);
			largest(root.right);
		}
		System.out.println(currentChar);
	}
}