import java.util.*;
import java.text.*;
import java.io.*;

class CS6085BTolani 
{
	
	static Lab5BTMethods one = new Lab5BTMethods();
	static int array[] ;
	static int counter=0;
	static int level = 0;
	static int right = 0;
	static int left  = 0;
	static int numberOfNodesInLevel = 0;
	static int levelWithMaxNodes = -1;
	static File f1;
	static PrintWriter pw;

	public static void main(String[] args) throws Exception
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
	static void levelWithLargestNumberOfNodes(Lab5BTNode root) throws Exception
	{
		
		f1 = new File("temp.txt");
		pw = new PrintWriter("temp.txt");
		boolean b1 = f1.createNewFile();
		//System.out.println(b1);
		if(!b1){
			for(int i = 0 ; i < (one.height(root)); i++)
			{
				printElementsOnALevel(one.root,i);
				pw.println();
			}
			pw.flush(); pw.close();
		}
		
		boolean b2 = f1.exists();
		//System.out.println(b2);

		if(b2)
		{
			Scanner sc = new Scanner(f1);
			int count = 0;
			String lev0="",lev1="",lev2="",lev3="",lev4="",lev5="",lev6="",lev7 = "",lev8 = "",lev9 = "",lev10 = "";
			while (sc.hasNextLine())
			{
				if(count==0)
					lev0 = sc.nextLine();
				if(count==1)
					lev1 = sc.nextLine();
				if(count==2)
					lev2 = sc.nextLine();
				if(count==3)
					lev3 = sc.nextLine();
				if(count==4)
					lev4 = sc.nextLine();
				if(count==5)
					lev5 = sc.nextLine();
				if(count==6)
					lev6 = sc.nextLine();
				if(count==7)
					lev7 = sc.nextLine();
				if(count==8)
					lev8 = sc.nextLine();
				if(count==9)
					lev9 = sc.nextLine();
				if(count==10)
					lev10 = sc.nextLine();
				count++;
			}
			StringTokenizer tokens = new StringTokenizer(lev0," ");
			int firstcount = tokens.countTokens();
			//System.out.println(firstcount);

			StringTokenizer tokens1 = new StringTokenizer(lev1," ");
			int secondcount = tokens1.countTokens();

			StringTokenizer tokens2 = new StringTokenizer(lev2," ");
			int thirdcount = tokens2.countTokens();

			StringTokenizer tokens3 = new StringTokenizer(lev3," ");
			int fourthcount = tokens3.countTokens();

			StringTokenizer tokens4 = new StringTokenizer(lev4," ");
			int fifthcount = tokens4.countTokens();

			StringTokenizer tokens5 = new StringTokenizer(lev5," ");
			int sixthcount = tokens5.countTokens();

			StringTokenizer tokens6 = new StringTokenizer(lev6," ");
			int seventhcount = tokens6.countTokens();

			StringTokenizer tokens7 = new StringTokenizer(lev7," ");
			int eighthcount = tokens7.countTokens();

			StringTokenizer tokens8 = new StringTokenizer(lev8," ");
			int ninthcount = tokens8.countTokens();

			StringTokenizer tokens9 = new StringTokenizer(lev9," ");
			int tenthcount = tokens9.countTokens();

			StringTokenizer tokens10 = new StringTokenizer(lev10," ");
			int eleventhcount = tokens10.countTokens();

			int temp[] = {firstcount,secondcount,thirdcount,fourthcount
				,fifthcount,sixthcount,seventhcount,eighthcount,ninthcount,tenthcount,eleventhcount};
				
				int maxValue = temp[0]; 

    	for(int i=1;i < temp.length;i++)
    	{ 
      		if(temp[i] > maxValue)
      		{ 
         		maxValue = temp[i]; 
         		
			}
		}System.out.println("Levels with max number of Nodes i.e "+maxValue+" nodes are as follows : " );
		
				if(maxValue == firstcount)
					System.out.println(lev0);
				if(maxValue == secondcount)
					System.out.println(lev1);
				if(maxValue == thirdcount)
					System.out.println(lev2);
				if(maxValue == fourthcount)
					System.out.println(lev3);
				if(maxValue == fifthcount)
					System.out.println(lev4);
				if(maxValue == sixthcount)
					System.out.println(lev5);
				if(maxValue == seventhcount)
					System.out.println(lev6);
				if(maxValue == eighthcount)
					System.out.println(lev7);
				if(maxValue == ninthcount)
					System.out.println(lev8);
				if(maxValue == tenthcount)
					System.out.println(lev9);
				if(maxValue == eleventhcount)
					System.out.println(lev10);
			f1.delete();
		}

	}
	
	static void printElementsOnALevel(Lab5BTNode root, int lev)throws Exception
	{
		if(root == null) return;
		if(lev == 0) pw.print(root.element + " ");
		else if(lev>0){
			printElementsOnALevel(root.left, lev-1);
			printElementsOnALevel(root.right, lev-1);
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