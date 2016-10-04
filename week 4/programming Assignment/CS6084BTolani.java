import java.util.*;
import java.io.*;
import java.text.*;

 class EvaluateInfix
{
	public static String normalizeEquation(String e) {
		
		//String e = "(100* 7+(7*7 ))";
		e = e.replaceAll("\\s","");
		//System.out.println(e); 
		
		StringTokenizer tokens = new StringTokenizer(e, "()^*/+-", true);
		//to seperate all the operands and operators 
		ArrayList<String> l1 = new ArrayList<String>();
        while(tokens.hasMoreTokens()){
        	l1.add(tokens.nextToken());
        	l1.add (" ");
        }
        String[] array = new String[l1.size()];
	    for (int i=0; i < array.length; i++)
	        array[i] = l1.get(i);
	    
	    StringBuffer buffer = new StringBuffer();
	    for (int i = 0; i < array.length; i++) {
	    	buffer.append(array[i]);
	    }

	    return buffer.toString();
	}
	public static double evaluate(String expression)
	{
		String exps = normalizeEquation(expression);
		System.out.println("Final Expression: "+exps);

		Stack<Double> values = new Stack<Double>();

		// Stack for Operators: 'ops'
		Stack<String> ops = new Stack<String>();

		Scanner sc = new Scanner(exps);

		while (sc.hasNext())
		{
			String tkn = sc.next();

			if(tkn.equals(" "))
			{
				continue;
			}

			//number encountred, put int to values stack
			if(tkn.matches("\\d+\\.\\d+")||tkn.matches("\\d+"))
			{
				values.push(Double.valueOf(tkn));
				//System.out.println("peek after add : "+ values.peek());
			}

			// Current token is an opening brace, push it to 'ops'
			else if (tkn.equals("("))
				ops.push(tkn);

			// Closing brace encountered, solve entire brace
			else if (tkn.equals(")"))
			{
				while (!(ops.peek()).equals("("))
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				ops.pop();
			}

			// Current token is an operator.
			else if(tkn.equals("^") || tkn.equals("*") || tkn.equals("/") || tkn.equals("+") || tkn.equals("-"))
            {
            	while (!ops.empty() && hasPrecedence(tkn, ops.peek()))
            	{
					//System.out.println(hasPrecedence(tkn, ops.peek()));
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
					//System.out.println(values.peek());
            	}


				// Push current token to 'ops'.
				ops.push(tkn);
			}
		}
		while (!ops.empty())
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));

		// Top of 'values' contains result, return it
		return values.pop();

	}

	// Returns true if 'op2' has higher or same precedence as 'op1',
	// otherwise returns false.
	public static boolean hasPrecedence(String op1, String op2)
	{
		if (op2.equals("(") || op2.equals(")"))
			return false;
		if ( (op1.equals("^")) && (op2.equals("+")|| op2.equals("-")))
            return false;
        if ( (op1.equals("^") ) && (op2.equals("*")|| op2.equals("/")))
            return false;
        if ( (op1.equals("*")) && (op2.equals("+")|| op2.equals("-")))
            return false;
        if ( (op1.equals("/")) && (op2.equals("+")|| op2.equals("-")))
            return false;
		else
			return true;
	}

	// A utility method to apply an operator 'op' on operands 'a' 
	// and 'b'. Return the result.
	public static double applyOp(String op, double b, double a)
    {
        switch (op)
        {
        case "^":
            return Math.pow(a,b);
        case "+":
            return a + b;
        case "-":
            return a - b;
        case "*":
            return a * b;
        case "/":
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }
}

class Input{

	String l1,l2,l3,l4,l5;
	Double[] firstOperators = new Double[4];
	Double[] secondOperators = new Double[4];
	Double[] thirdOperators = new Double[4];
	Double[] fourthOperators = new Double[4];
	Double[] fifthOperators = new Double[4];

	public Input(String filename) throws IOException
	{
		File f1 = new File(filename);
		if(!f1.exists())
			System.out.println("input file not found");

		Scanner sc = new Scanner(f1);
		int lineNumber = 0;
		while (sc.hasNextLine() && lineNumber < 10)
		{		
			if (lineNumber==0)
				l1 = sc.nextLine();

			if(lineNumber == 1)
			{
				String s = sc.nextLine();
				Scanner s1 = new Scanner(s);
				for (int i=0; i<4 ; i++ ) 
				{
					firstOperators[i] = s1.nextDouble();
				}
			}
			
			if (lineNumber==2)
				l2 = sc.nextLine();

			if(lineNumber == 3)
			{
				String s = sc.nextLine();
				Scanner s1 = new Scanner(s);
				for (int i=0; i<4 ; i++ ) 
				{
					secondOperators[i] = s1.nextDouble();
				}
			}
			
			if (lineNumber==4)
				l3 = sc.nextLine();

			if(lineNumber == 5)
			{
				String s = sc.nextLine();
				Scanner s1 = new Scanner(s);
				for (int i=0; i<4 ; i++ ) 
				{
					thirdOperators[i] = s1.nextDouble();
				}
			}
			
			if (lineNumber==6)
				l4 = sc.nextLine();

			if(lineNumber == 7)
			{
				String s = sc.nextLine();
				Scanner s1 = new Scanner(s);
				for (int i=0; i<4 ; i++ ) 
				{
					fourthOperators[i] = s1.nextDouble();
				}
			}
		
			if (lineNumber==8)
				l5 = sc.nextLine();

			if(lineNumber == 9)
			{
				String s = sc.nextLine();
				Scanner s1 = new Scanner(s);
				for (int i=0; i<4 ; i++ ) 
				{
					fifthOperators[i] = s1.nextDouble();
				}
			}

			
			
			lineNumber++;
		}
	//System.out.println(l1);
	//for (double x : firstOperators) {
	//	System.out.println(x);
	//}
	}

    public String getFirstStringRaw(){
        return l1;
    }
    public String getSecondStringRaw(){
        return l2;
    }
    public String getThirdStringRaw(){
        return l3;
    }
    public String getFourthStringRaw(){
        return l4;
    }
    public String getFifthStringRaw(){
        return l5;
    }
    public Double[] getFirstValues()
    {
    	return firstOperators;
    }
    public Double[] getSecondValues()
    {
    	return secondOperators;
    }
    public Double[] getThirdValues()
    {
    	return thirdOperators;
    }
    public Double[] getFourthValues()
    {
    	return fourthOperators;
    }
    public Double[] getFifthValues()
    {
    	return fifthOperators;
    }
	public String getFirstString()
	{ 
		l1 = l1.replace("a",String.valueOf(firstOperators[0]));
		l1 = l1.replace("b",String.valueOf(firstOperators[1]));
		l1 = l1.replace("c",String.valueOf(firstOperators[2]));
		l1 = l1.replace("d",String.valueOf(firstOperators[3]));	
	    return l1;		
	}
	public String getSecondString()
	{ 
		l2 = l2.replace("a",String.valueOf(secondOperators[0]));
		l2 = l2.replace("b",String.valueOf(secondOperators[1]));
		l2 = l2.replace("c",String.valueOf(secondOperators[2]));
		l2 = l2.replace("d",String.valueOf(secondOperators[3]));	
	    return l2;		
	}
	public String getThirdString()
	{ 
		l3 = l3.replace("a",String.valueOf(thirdOperators[0]));
		l3 = l3.replace("b",String.valueOf(thirdOperators[1]));
		l3 = l3.replace("c",String.valueOf(thirdOperators[2]));
		l3 = l3.replace("d",String.valueOf(thirdOperators[3]));	
	    return l3;		
	}
	public String getFourthString()
	{ 
		l4 = l4.replace("a",String.valueOf(fourthOperators[0]));
		l4 = l4.replace("b",String.valueOf(fourthOperators[1]));
		l4 = l4.replace("c",String.valueOf(fourthOperators[2]));
		l4 = l4.replace("d",String.valueOf(fourthOperators[3]));	
	    return l4;		
	}
	public String getFifthString()
	{ 
		l5 = l5.replace("a",String.valueOf(fifthOperators[0]));
		l5 = l5.replace("b",String.valueOf(fifthOperators[1]));
		l5 = l5.replace("c",String.valueOf(fifthOperators[2]));
		l5 = l5.replace("d",String.valueOf(fifthOperators[3]));	
	    return l5;		
	}
}
class MyInfo{
  String todaysDate = "29/SEP/2016";
  String assignmentNumber = "4B";

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
    System.out.println("Assingment " +assignmentNumber+ " \nDone on : "+dateformat3.format(assingmentDate));
    System.out.println("--------------------------------------------------------");
  }
}

public class CS6084BTolani{
	public static void main(String[] args) throws Exception {

		new MyInfo().identity();
		//to read all the data
		Input ip = new Input("inputData4B.txt");

		//expression 1
		System.out.print("Given Expression : ");
		System.out.println(ip.getFirstStringRaw());//will give the equation in form of variables
		Double[] a = ip.getFirstValues();//will give the values for variables
		System.out.print("Values : ");
		for (Double i: a  ) 
			System.out.print (i + " ");
		System.out.println();
		String expOne = ip.getFirstString();//will give the expression with the values.
		//System.out.println(expOne);
        System.out.println("Answer: "+ new EvaluateInfix().evaluate(expOne));
        System.out.println();

       //expression 2
        System.out.print("Given Expression : ");
		System.out.println(ip.getSecondStringRaw());
		Double[] b = ip.getSecondValues();
		System.out.print("Values : ");
		for (Double i: b  ) 
			System.out.print (i + " ");
		System.out.println();
        String expTwo = ip.getSecondString();
        System.out.println("Answer: "+ new EvaluateInfix().evaluate(expTwo));
        System.out.println();

        //expression 3
        System.out.print("Given Expression : ");
        System.out.println(ip.getThirdStringRaw());
		Double[] c = ip.getThirdValues();
		System.out.print("Values : ");
		for (Double i: c  ) 
			System.out.print (i + " ");
		System.out.println();
        String expThree = ip.getThirdString();
        System.out.println("Answer: "+ new EvaluateInfix().evaluate(expThree));
        System.out.println();

        //expression 4
        System.out.print("Given Expression : ");
        System.out.println(ip.getFourthStringRaw());
		Double[] d = ip.getFourthValues();
		System.out.print("Values : ");
		for (Double i: d  ) 
			System.out.print (i + " ");
		System.out.println();
        String expFour = ip.getFourthString();
        System.out.println("Answer: "+ new EvaluateInfix().evaluate(expFour));
        System.out.println();

        //expression 5
        System.out.print("Given Expression : ");
        System.out.println(ip.getFifthStringRaw());
		Double[] e = ip.getFifthValues();
		System.out.print("Values : ");
		for (Double i: e  ) 
			System.out.print (i + " ");
		System.out.println();
        String expFive = ip.getFifthString();
        System.out.println("Answer: "+ new EvaluateInfix().evaluate(expFive));
        System.out.println();

        System.out.println();

	}
}
