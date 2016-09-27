
import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Input{

	ArrayList<Integer> l1 = new ArrayList<Integer>();//ArrayList because, We dont know what is the length from the input.
	int insertAtBegin=-1, insertAtLast=-1, searchElement=-1;

	public  void takeInput(String filename) throws IOException
	{
		File f1 = new File(filename);
		if(!f1.exists())
			System.out.println("input file not found");
		Scanner sc = new Scanner(f1);
		int lineNumber=0;
		while (sc.hasNextLine() && lineNumber < 4)
		{
			String line = sc.nextLine();
			Scanner lineReader = new Scanner(line);
			
			if (lineNumber==0){//for reading the array
				while(lineReader.hasNextInt())
					l1.add(lineReader.nextInt());
				removeLast();// because the zero isnt included in the input
			}
			
			if (lineNumber==1)//takes the search element from the file
				searchElement = lineReader.nextInt();
			
			if (lineNumber==2)//takes the element to be inserted in the begining
				insertAtBegin = lineReader.nextInt();
			
			if (lineNumber==3)//takes the element to be inserted in the last
				insertAtLast = lineReader.nextInt();

			lineNumber++;
		}
	}
	//now that we have the size of the aaraylist, we can convert it to array to pass it around
	public int[] getInputArray()
	{ 
		int[] array = new int[l1.size()];
	    for (int i=0; i < array.length; i++)
	    {
	        array[i] = l1.get(i).intValue();
	    }

	    return array;		
	}
	//just getters to get the elements
	public int getInsertAtBeginningElement()
	{
		return insertAtBegin;
	}
	public int getInsertAtLastElement()
	{
		return insertAtLast;
	}
	public int getSearchElement()
	{
		return searchElement;
	}
	public  void removeLast()
	{
		l1.remove(l1.size()-1);
	}

}
class myLinkedList 
{
	private static class Node 
	{
		private int data; 
		private Node next;
		
		public Node(int data, Node next) 
		{
			this.data = data;
			this.next = next; 
		}
	}
	
	private Node head;
	
	// Constructs an empty list
	public myLinkedList() 
	{
		head = null; 
	}
	
	// Returns true if the list is empty otherwise returns false
	public boolean isEmpty() 
	{
		return (head == null); 
	}

	// Inserts a new node at the beginning of this list.	
	public void insertAtBeginning(int element) 
	{
		head = new Node(element, head); 
	}
	
	// Returns the first element in the list.
	public int getFirstElement() 
	{
		if(head == null) 
		{
			System.out.println("Empty linked list"); 
			throw new IndexOutOfBoundsException();
		}
		return head.data; 
	}
	
	// Removes the first node in the list.
	public int removeFirstNode() 
	{ 
		int tmp = getFirstElement(); 
		head = head.next;
		return tmp;
	}
	
	// Empties linked list 
	public void clear() 
	{
		head = null; 
	}
	
	// Returns the length of the linked list
	public static int LLlength(Node head)
	{ 
		int length = 0;
		Node currentNode = head; 

		while(currentNode != null)
		{
			length++;
			currentNode = currentNode.next; 
		}
		return length; 
	}

	// Displays the linked list elements
	public static void display(Node head)
	{ 
		if(head == null) 
		{
			System.out.println("Empty linked list");
			throw new IndexOutOfBoundsException(); 
		}
		
		Node currentNode = head; 
		
		while(currentNode != null)
		{
			System.out.print(currentNode.data+" ");
			currentNode = currentNode.next; 
		}
		System.out.println();
	}

	// Displays the linked list elements in reverse order 
	public static void displayReverse(Node head)
	{
		if(head == null){} 
		else
		{
			Node currentNode = head; 
			displayReverse(currentNode.next); 
			System.out.print(currentNode.data+" ");
		} 
	}
	//Displays the linked list's last element
	public static int getLastElement(Node head)
	{
		Node currentNode = head; 
		
		while(currentNode.next != null)
		{
			currentNode = currentNode.next; 
		}
		return currentNode.data;
	}
	//inserts the element at last
	public static void insertAtLast(Node head,int element)
	{
		Node newNode= new Node(element,null);
		Node temp = head;
    	while(temp.next != null)
    	{
        	temp = temp.next; 
    	}
    	temp.next = newNode;
		//return head;

	}

	//Tells if a sepeific element is in the Linked List or not
	public static boolean searchFor(Node head, int element)
	{
		Node currentNode = head; 
		boolean flag = false;
		while(currentNode != null)
		{
			if (currentNode.data == element)
			{
				flag = true;
				break;
			} 
			currentNode = currentNode.next;
		}
		return flag;
	}
	public void startOperations() throws IOException
	{
		Input myinput  = new Input();
		myinput.takeInput("dataForLinkedList.txt");
		int inputList[] = myinput.getInputArray();
		myLinkedList list = new myLinkedList();
		for(int a  = inputList.length-1; a >= 0 ; a--)
		{
			list.insertAtBeginning(inputList[a]);
		}
		System.out.print("The Linked List : "); display(list.head);
		System.out.println("The Size of the Linked List : " + LLlength(list.head));
		System.out.println("Searching For " + myinput.getSearchElement() +" : "+ searchFor(list.head , myinput.getSearchElement()));
		System.out.println("The Last Element of the Linked List : "+ getLastElement(list.head));
		System.out.print("Inserting "+ myinput.getInsertAtBeginningElement()+" At the beginning. ");
		list.insertAtBeginning(myinput.getInsertAtBeginningElement());
		display(list.head);
		System.out.print("Inserting "+ myinput.getInsertAtLastElement()+" At the last. ");
		list.insertAtLast(list.head , myinput.getInsertAtLastElement());
		display(list.head);
		System.out.println("\n");
		
	} 
}
class CS6083ATolani{
	public static void main(String[] args) throws IOException
	{
		new MyInfo().identity();
		new myLinkedList().startOperations();
	} 
}
class MyInfo{
  String todaysDate = "22/SEP/2016";

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
    System.out.println("Assingment(3A) done on : "+dateformat3.format(assingmentDate));
    System.out.println("--------------------------------------------------------");
  }
}