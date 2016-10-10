import java.util.*;
import java.text.*;
class CS6085ATolani {
	static Lab5BTMethods one = new Lab5BTMethods();
	static int array[] ;
	static int counter=0;
	
	public static void main(String[] args) {
		new MyInfo().identity();
		one.createBinaryTree();
		array = new int[numberOfNodes(one.root)];
		System.out.println();
		System.out.println("Pre Order Travesal");
		one.preOrder(one.root);
		System.out.println("\n");
		System.out.println("Height of the Tree = "+one.height(one.root));
		System.out.print("\nThe Level Order of the Tree");
		one.displayTree(one.root);
		System.out.println("\n");
		System.out.println("Number of nodes in the tree : "+numberOfNodes(one.root));
		System.out.println("\nLargest Value in the tree : "+largest(one.root));
		System.out.println("\n");
	}
	static int numberOfNodes(Lab5BTNode root){
		if(root == null)
			return 0;
		else 
			return(numberOfNodes(root.right) + numberOfNodes(root.left) + 1);
	}
	static int largest(Lab5BTNode root){
		int temp = 0;
		if(root!=null)
		{
			array[counter++] = root.element;
			largest(root.left);
			largest(root.right);
		}
		for (int i =0; i<array.length; i++) {
			if(array[i]>temp){
				temp = array[i];
			}
		}
		return temp;
	}
	
}
class MyInfo{
  String todaysDate = "06/OCT/2016";
  String assignmentNumber = "5A";

  public void identity(){
  // My info and class and assigmnegt date and all
    System.out.println("\n");
    System.out.println("Name : Mayur Tolani");
    System.out.println("Course : CS608");
    SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MMM/yyyy");
    Date assingmentDate = null;
    try{
        assingmentDate = dateformat3.parse(todaysDate); //Date printing, using the DATE class in java.
      } 
      catch (ParseException ex) {
          System.out.print(ex);
      }
    System.out.println("Assingment " +assignmentNumber+ "\nDone on : "+dateformat3.format(assingmentDate));
    System.out.println("--------------------------------------------------------");
  }
}