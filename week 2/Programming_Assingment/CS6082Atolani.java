import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CS6082Atolani{
	public static void main(String args[])
	{
		MyInfo id = new MyInfo();
    	id.identity(); //this will print my name, course details, and the date.

    	long pair1[] = {96,72}; //making pairs of the numbers, whose GCD is to be found
    	long pair2[] = {63245986,514229};
    	long pair3[] = {701408733,3524578};

		GCD one = new GCD(pair1[0],pair1[1]); //making differnt objects for different pairs, so as to maintain different copies of the same variable
		System.out.println("GCD of ("+ pair1[0] +","+pair1[1]+") : " + one.euclidsAlgo() + " and the counter value is "+ one.getCounter());
		
		GCD two = new GCD(pair2[0],pair2[1]);
		System.out.println("GCD of ("+pair2[0]+","+pair2[1]+") : " + two.euclidsAlgo() + " and the counter value is "+ two.getCounter());
		
		GCD three = new GCD(pair3[0],pair3[1]);
		System.out.println("GCD of ("+pair3[0]+","+pair3[1]+") : " + three.euclidsAlgo() + " and the counter value is "+ three.getCounter()+"\n\n");
	}
}
class GCD{
	int counter = 0;
	long a,b;
	public GCD(long a , long b)
	{//constructor to intialize the variables.
		this.a = a;
		this.b = b;
	}
	public long euclidsAlgo()
	{//euclidean algorithm for finding GCD
		long rem = 0;
		while(b!=0){
			rem = a % b;
			a = b; 
			b = rem;
			counter++;
		} return a;
	}
	public int getCounter()
	{// function ro return the number of runs it takes, to find the GCD using the Euclideans Algorithm
		return counter;
	}
}
class MyInfo{// this will print the mandatory details of as my name, the subject and the Date 
  public void identity()
  {
    	System.out.println("\n");
    	System.out.println("Name : Mayur Tolani");
    	System.out.println("Course : CS608");
    	SimpleDateFormat dateformat = new SimpleDateFormat("dd/MMM/yyyy");
    	Date assingmentDate = null;
    	try
    	{
        	assingmentDate = dateformat.parse("15/SEP/2016"); //Date printing, using the DATE class in java.
      	} 
      	catch (ParseException ex) 
      	{
          System.out.print(ex);
      	}
    	System.out.println("Assingment(2A) done on : "+dateformat.format(assingmentDate));
    	System.out.println("-----------------------------------------");
  }
}