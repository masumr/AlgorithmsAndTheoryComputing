import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;

public class CS6082Btolani{
	public static void main(String args[]){
		new MyInfo().identity(); //this will print my name, course details, and the date.
		new MaxSequenceSumProblem().firstAlgo(); //First Algorithm with just refernce and calling the method too (on the fly)
		new MaxSequenceSumProblem().secondAlgo();//second Algo on the fly method call too. no object, just the refernce created, saving space complexity.
		new MaxSequenceSumProblem().thirdAlgo();// third algo, again on the fly call for the method.
		new MaxSequenceSumProblem().fourthAlgo();//fourth algorithm
		new MaxSubArray().findSubArray();
	}
}
class MaxSequenceSumProblem{
	int a[] = {33,6,16,1,7,-49,53,95,48,79,-42,27,63,-22,60,90,13,2,8,51,28,18,30,93,98,44,26,24,
			   35,70,66,89,-61,9,-43,87,38,92,3,-80,55,78,32,50,77,73,-83,17,19,31,39,76,62,96,-23,
			   65,72,4,37,12,-54,15,94,21,-52,58,64,40,59,82,81,41,-57,69,25,97,-11,47,88,-36,20,
			   68,67,34,-45,10,56,91,29,14,74,-46,84,100,5,86,99,75,-85,71};// everthing is dependent on this array, if this is wrong, all goes wrong.

	public void firstAlgo(){
		//this the first Algorithm
		Timer t1 = new Timer(); // T1 object for timer. will be keeping differnet abjects of timers, so as to make differnt copies of the respected variables in the class
		t1.startTimer(); // timer starts
		
		int maxSum = 0;//actual code starts for the first algorithm
		for( int i = 0; i < a.length; i++ )//first for loop running n times
    		for( int j = i; j < a.length; j++ ){// second for loop running n times 
				int thisSum = 0;// this will keep present value of the sum
        		for( int k = i; k <= j; k++ )// third for loop making the complexity of algo as n^3
            		thisSum += a[ k ];// calculating the new Sum
        		if( thisSum > maxSum )// calculating which is bigger, new or old?
            		{
            			maxSum = thisSum;// if new is bigger, assign it to max sum
            		}
    		}
		System.out.println("The Sum of the Sequence for with first Algorithms is " + maxSum);
		System.out.print("The Time taken by the first Algorithm is : ");
		t1.endTimer(); //this will call off the timer and the time taken will be displayed in milliseconds.
	}
	public void secondAlgo(){
		//System.out.print("Second Algorithm");
		Timer t2 = new Timer();
		t2.startTimer();

		int maxSum = 0;
		for( int i = 0; i < a.length; i++ ){//loop for n values
			int thisSum = 0;
			for( int j = i; j < a.length; j++ ){// loop making the complexity n^2
				thisSum += a[ j ];
				if( thisSum > maxSum )
    				maxSum = thisSum;
			} 
		}
	 	System.out.println("\nThe Sum of the Sequence for with second Algorithms is " + maxSum);
	 	System.out.print("The Time taken by the second Algorithm is : ");
		t2.endTimer();
	}
	public void thirdAlgo(){
		//System.out.print("Third Algorithm");
		Timer t3 = new Timer();
		t3.startTimer();
		// could define a new variable and store the value of the maxSum, but decided to save those integer bytes and call the object on the fly in the next statement.
		System.out.println("\nThe Sum of the Sequence for with third Algorithms is " + new MaxSequenceSumProblem().maxSumRec( 0, a.length-1 ));
		System.out.print("The Time taken by the third Algorithm is : ");

		t3.endTimer();
	}

	public  int maxSumRec(int left, int right){

		if(left == right)//base case or say breaking case
		{
			if (a[ left ] > 0)
				return a[ left ];
			else 
				return 0;
		}
		int center = (left+right)/2;
		int maxLeftSum = maxSumRec(left, center);//divide and call again
		int maxRightSum = maxSumRec(center + 1 , right);// divide and call again

		int maxLeftBorderSum = 0, leftBorderSum = 0;
		for( int i = center; i >= left; i-- ){
			leftBorderSum +=a [ i ];
			if(leftBorderSum > maxLeftBorderSum)
				maxLeftBorderSum = leftBorderSum;
		}
		int maxRightBorderSum = 0,rightBorderSum = 0;
		for( int i =center+1; i <= right; i++ ){
			rightBorderSum += a[i];
			if(rightBorderSum > maxRightBorderSum)
				maxRightBorderSum = rightBorderSum;
		}
		return ( ( maxLeftSum > maxRightSum ? // using ternary Condition statments like a boss. 
				 ( maxLeftSum > maxLeftBorderSum + maxRightBorderSum ? maxLeftSum : maxLeftBorderSum + maxRightBorderSum )  :
				 ( maxRightSum > maxLeftBorderSum + maxRightBorderSum ? maxRightSum : maxLeftBorderSum + maxRightBorderSum ) ) 
				); // could also use Math.max() but wanted to pratice this. so cool :P
	}


	public void fourthAlgo(){
		//System.out.println("fourth Algorithm");
		Timer t4 = new Timer();
		t4.startTimer();

		int maxSum = 0, thisSum = 0;
		for( int j = 0; j < a.length; j++ ){
     		thisSum += a[ j ];
     		if( thisSum > maxSum ){
        	 	maxSum = thisSum; 
     		}
     		else if( thisSum < 0 )
         		thisSum = 0; // this will give us only the sum, if it is positive. It will fail for negative sum, but time complexity is linear, so cool.
 		}
 		System.out.println( "\nThe Sum of the Sequence for with fourth Algorithms is " + maxSum );
		System.out.print("The Time taken by the fourth Algorithm is : ");
		t4.endTimer();
	}
}
class MaxSubArray{
	public void findSubArray() {
		int a[] = {33,6,16,1,7,-49,53,95,48,79,-42,27,63,-22,60,90,13,2,8,51,28,18,30,93,98,44,26,24,
			   35,70,66,89,-61,9,-43,87,38,92,3,-80,55,78,32,50,77,73,-83,17,19,31,39,76,62,96,-23,
			   65,72,4,37,12,-54,15,94,21,-52,58,64,40,59,82,81,41,-57,69,25,97,-11,47,88,-36,20,
			   68,67,34,-45,10,56,91,29,14,74,-46,84,100,5,86,99,75,-85,71};
	 	
	 	int maxSum = 0, start=0, end = 0;
 
        for( int i = 0; i < a.length; i++ )
            for( int j = i; j < a.length; j++ )
            {
                int thisSum = 0;
 
                for( int k = i; k <= j; k++ )
                    thisSum += a[ k ];
 
                if( thisSum > maxSum )
                {
                    maxSum   = thisSum;
                    start = i;
                    end   = j;
                }
            }
    	System.out.println("\nThe sub array with the actual Sequence is \n"+Arrays.toString(Arrays.copyOfRange(a, start, end+1))+"\n\n");//Array.toString made things a bit simpler.
    																																	//functions lik Arrays.copyOfRange made me love Jave <3
	}
}


class Timer{// this will be used to calculate the time taken by the code to run in milli seconds
	
	private long startTime; // long because, the millisenconds are shown from a date in 1970's 

	public void startTimer(){
		startTime = System.currentTimeMillis();
	}
	public void endTimer(){
		System.out.println((System.currentTimeMillis() - startTime)+ " Milli Seconds.");// no returning anything, simply, printing it.
	}
}

class MyInfo{
	String todaysDate = "15/SEP/2016";

  public void identity(){// My info and class and assigmnegt date and all
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
    System.out.println("Assingment(2B) done on : "+dateformat3.format(assingmentDate));
    System.out.println("--------------------------------------------------------");
  }
}