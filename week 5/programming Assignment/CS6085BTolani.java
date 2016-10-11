import java.util.*;
import java.text.*;
class CS6085BTolani {
	
	static Lab5BTMethods one = new Lab5BTMethods();
	static int array[] ;
	static int counter=0;
	static int level = 0;
	static int right = 0;
	static int left  = 0;
	static int numberOfNodesInLevel = 0;
	static int levelWithMaxNodes = -1;

	public static void main(String[] args) 
	{
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
		System.out.println();
		System.out.println("Sum of Elements : " + sumOfElements(one.root));
		System.out.println();
		int x = 10;//search element
		System.out.println("Search for Number " + x +" : "+searchFor(one.root,x));
		System.out.println();
		levelWithLargestNumberOfNodes(one.root);
		System.out.println("Max Number of Nodes in any Level : "+(numberOfNodesInLevel+1));
		System.out.println("\nlevel with max nodes : "+levelWithMaxNodes);
		System.out.println();
	}
	static int numberOfNodes(Lab5BTNode root)
	{
		if(root == null)
			return 0;
		else 
			return(numberOfNodes(root.right) + numberOfNodes(root.left) + 1);
	}
	static void toArray(Lab5BTNode root)
	{

		if(root!=null)
		{
			array[counter++] = root.element;
			toArray(root.left);
			toArray(root.right);
		}
	}
	static int largest(Lab5BTNode root)
	{
		int large = 0;
		counter=0;
		toArray(root);
		for (int i =0; i<array.length; i++) {
			if(array[i]>large){
				large = array[i];
			}
		}
		return large;
	}
	
	// program for Assignment B
	static int sumOfElements(Lab5BTNode root)
	{
		counter=0;
		toArray(root);
		int sum=0;
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}
		return sum;
	}
	static boolean searchFor(Lab5BTNode root, int n)
	{
		counter=0;
		toArray(root);
		for (int i =0; i<array.length; i++)
			if(array[i]==n)
				return true;
		return false;
	}
	static void levelWithLargestNumberOfNodes(Lab5BTNode root)
	{
		right=0;
		left = 0;
		if (root == null) return;
		else
		{
			levelWithLargestNumberOfNodes(root.right);
			right++;
			
			levelWithLargestNumberOfNodes(root.left);
			left++;
			
			
			if((left+right) > numberOfNodesInLevel)
			{
				if(level > levelWithMaxNodes)
				{
					levelWithMaxNodes = level;
				}
				numberOfNodesInLevel = left+right;
				
			}
			level++;
			//System.out.println(numberOfNodesInLevel+1);
		}

	}
	
}
class MyInfo
{
  String todaysDate = "06/OCT/2016";
  String assignmentNumber = "5B";

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