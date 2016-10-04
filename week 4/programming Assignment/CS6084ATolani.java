
import java.util.*;
import java.io.*;
import java.text.*;

class CS6084ATolani {
	public static void main(String[] args) throws IOException{
		new MyInfo().identity();
		myStack operatorsStack = new myStack(20);
		Input ip = new Input("infixData4A.txt");	
		String[] infixExpressions = ip.getInputArray();
		String infixExpression;
		for (int k = 0; k< infixExpressions.length; k++) {
			infixExpression = infixExpressions[k];
			String output = "";
			for (int i = 0; i<infixExpression.length(); i++) {
				char currentChar = infixExpression.charAt(i);
				if(currentChar >= 'a' && currentChar <= 'z'){
					output += currentChar;
				}else{
					switch(currentChar){
						case '+' :
						case '-' :
						if(operatorsStack.isEmpty())
							operatorsStack.push(currentChar);
						else{
							while(!operatorsStack.isEmpty())
								output += (char) operatorsStack.pop();
							operatorsStack.push(currentChar);
						}
						break;
						case '*' :
						case '/' :
						if(operatorsStack.isEmpty() || operatorsStack.topElement() == '+' || operatorsStack.topElement() == '-')
							operatorsStack.push(currentChar);
						else{
							while(!operatorsStack.isEmpty() && operatorsStack.topElement() != '+' && operatorsStack.topElement() != '-')
								output += (char)operatorsStack.pop();
							operatorsStack.push(currentChar);
						}
						break;
						case '^' :
						if(operatorsStack.isEmpty() || operatorsStack.topElement() == '+' || operatorsStack.topElement() == '-'|| operatorsStack.topElement() == '*')
							operatorsStack.push(currentChar);
						else{
							while(!operatorsStack.isEmpty() && operatorsStack.topElement() != '+' && operatorsStack.topElement() != '-' && operatorsStack.topElement() == '*')
								output += (char)operatorsStack.pop();
							operatorsStack.push(currentChar);
						}
						break;
						case ' ' : break;
					}
				}
			}
			while(!operatorsStack.isEmpty())
				output += (char)operatorsStack.pop();
			System.out.println("Given Expression: "+ infixExpression);
			System.out.println("Postfix Expression: " + output +"\n");
		}
	}
}
class myStack{
	private int top;
	private char[] operatorsArray;

	public myStack(int size){
		operatorsArray = new char[size];
		top =- 1;
	}
	public void push(char op){
		top++;
		operatorsArray[top] = op;
	}
	public char pop(){
		return operatorsArray[top--];
	}
	int topElement(){
		return operatorsArray[top];
	}
	public boolean isEmpty(){
		return (top == -1);
	}
}

class Input{

	String l1,l2,l3,l4,l5;
	public Input(String filename) throws IOException
	{
		File f1 = new File(filename);
		if(!f1.exists())
			System.out.println("input file not found");

		Scanner sc = new Scanner(f1);
		int lineNumber = 0;
		while (sc.hasNextLine() && lineNumber < 5)
		{		
			if (lineNumber==0)
				l1 = sc.nextLine();
			
			if (lineNumber==1)
				l2 = sc.nextLine();
			
			if (lineNumber==2)
				l3 = sc.nextLine();
			
			if (lineNumber==3)
				l4 = sc.nextLine();
		
			if (lineNumber==4)
				l5 = sc.nextLine();
			
			lineNumber++;
		}
	}
	public String[] getInputArray()
	{ 
		String[] array = {l1,l2,l3,l4,l5};
	    
	    return array;		
	}
	
}
class MyInfo{
  String todaysDate = "29/SEP/2016";
  String assignmentNumber = "4A";

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