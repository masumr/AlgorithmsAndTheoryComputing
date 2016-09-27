import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CS6081Axxxxx{
  public static void main(String[] args){
    MyInfo id = new MyInfo();
    id.identity(); //this will print my name, course details, and the date.

    int arr[] = {1000,2000,3000,4000,5000,6000,7000,8000,9000,10000}; //pre intialized array, because we know that we have to run the code(series) with these numbers.         
    float sums[]  = new float[]{0,0,0,0,0,0,0,0,0,0}; // this will store the sums of each value after passing it over the series.
    int index = 0;      // index for accessing the above array    
    for (int j=0;j<10 ;j++, index++){
       Convergence sr = new Convergence();
       sums[index] = sr.calculateSum(arr[j]); // will do the main part of the program. calculation of sum.
    }
    Convergence givenSeries = new Convergence();
    givenSeries.isConvergent(sums); //will tell if the series is convergent or not
  }
}
 class Convergence{
    private float sum = 0;
    private float denominator = 1;
    
    public float calculateSum(int n){ //this will calculate Sum of the series, if the series changes, this function will change.
      for(int i = 0; i < n; i++, denominator++ ){
        sum = sum + (1/(denominator*denominator));
      }
      return sum;
    }
    public void isConvergent(float[] array){
      //this will finally calculate if the sum of the series is convergent or not!
         Boolean answerArray[] = new Boolean[9]; //this array will hold true or false, 
        //true stating that the differnce is below 0.0001 and false meaning the differnce is above.
        for (int i=1;i<10;i++){
            answerArray[i-1] = ((array[i-1] - array[i]) < 0.0001);
        }
        boolean flag = true;
        for (int i=0;i<9;i++) {// running a loop to check if the entire array satisfies the condition for being convergent or not.
            if(answerArray[i] == false){
                flag = false;
                break;
            }
        }
        if (flag){
            System.out.println("The Series is Convergent.");
            System.out.println("The value that remains constant after few iterations is : " + array[6]);
            System.out.println("\n");
        }
        else{
            System.out.println("The Series is Divergent.");
            System.out.println("\n");
        }
    }
  }

class MyInfo{
  public void identity(){
    System.out.println("\n");
    System.out.println("Name : Mayur Tolani");
    System.out.println("Course : CS608");
    SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MMM/yyyy");
    Date assingmentDate = null;
    try{
        assingmentDate = dateformat3.parse("08/SEP/2016"); //Date printing, using the DATE class in java.
      } 
      catch (ParseException ex) {
          System.out.print(ex);
      }
    System.out.println("Assingment(1A) done on : "+dateformat3.format(assingmentDate));
    System.out.println("---------------------------");
  }
}