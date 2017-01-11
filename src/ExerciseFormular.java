
import java.math.BigInteger;

/*
 In this program I made use of Big Integer data type because integer typr cannot
carry out operation on large integer i.e we cannot get the correct ans of the factorial of
a large integer. Therefore i made use of Big integer.
 */

/**
 *
 * @author samdwise
 */
public class ExerciseFormular {
     
    //this method will be able to find factorial of any postive number
    public BigInteger factorial(int a){
        BigInteger result = BigInteger.ONE;
            for (int i=1; i<=a; i++) {
	            result = result.multiply(BigInteger.valueOf(i));
	        }        

	     return result;   
        }
       // return fact;
    
    
   public int permutation(int n, int r){
       BigInteger resultN = BigInteger.ONE;
       BigInteger resultR = BigInteger.ONE;
       BigInteger resultAns = BigInteger.ONE;
       int diffNR = n-r;
       
       //perform n! 
       for (int i=1; i<=n; i++) {
	            resultN = resultN.multiply(BigInteger.valueOf(i));
	        }
       
       //perform (n-r)! 
       for (int i=1; i<=diffNR; i++) {
	            resultR = resultR.multiply(BigInteger.valueOf(i));
	        }
       
       // perform n!/(n-r)!
        resultAns = resultN.divide(resultR);
              
        //convert the result to integer and return
        return resultAns.intValue();
                        
                //System.out.println();
   
   }
   
   public int combination(int n, int r){
       BigInteger resultN = BigInteger.ONE;
       BigInteger resultR = BigInteger.ONE;
       BigInteger resultNR = BigInteger.ONE;
       BigInteger resultAns = BigInteger.ONE;
       BigInteger resultAns1 = BigInteger.ONE;
       
       int diffNR = n-r;
       
       //perform n!
       for (int i=1; i<=n; i++) {
	            resultN = resultN.multiply(BigInteger.valueOf(i));
	        }
       //perform r!
       for (int i=1; i<= r; i++) {
	            resultR = resultR.multiply(BigInteger.valueOf(i));
	        }
       
       //perform (n-r)!
       for (int i=1; i<= diffNR; i++) {
	            resultNR = resultNR.multiply(BigInteger.valueOf(i));
	        }
       
       //perform r!(n-r)!
        resultAns1 = resultR.multiply(resultNR);
        //perform n!/[r!(n-r)!], convert the result to integer and return
        return resultN.divide(resultAns1).intValue();
       
   }
   
   public int function(int n, int r){
       int ans=0;
       if((n > 0 && n <= 13 ) && (r >= 0 && r < 6)){
               ans = 0;
       }else if(n*n >= 30 && n*n < 64 ){
           ans = 1;
       }else 
           ans = -1;
       
       return ans;
   }
   

}
