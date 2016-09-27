import java.math.BigInteger;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CS6083BTolani {

   public static void main(String[] args) 
   {
    new MyInfo().identity();
      boolean flag = true;
      while(flag)
      {
         Scanner s = new Scanner(System.in);
         System.out.print("Enter the number for finding Factorial : ");
         int n = s.nextInt();
         String fact = factorial(n);
         System.out.println("Factorial is " + fact);
         System.out.println("Do you want to continue? (Y/N) ?");
         if(s.next().equalsIgnoreCase("n"))
            {
              flag = false;
              System.out.println("\n");
            }
     }
  }

   public static String factorial(int n) {
       BigInteger fact = new BigInteger("1");
       for (int i = 1; i <= n; i++) {
           fact = fact.multiply(new BigInteger(i + ""));
       }
       return fact.toString();
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
    System.out.println("Assingment(3B) done on : "+dateformat3.format(assingmentDate));
    System.out.println("--------------------------------------------------------");
  }
}

