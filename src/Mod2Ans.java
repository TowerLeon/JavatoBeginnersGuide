/**
 * FileName: Mod2Ans
 * Author:   Chris Li
 * Date:     9/6/2018 8:34 PM
 * Description:
 * History:
 */

listing 1
// Find prime numbers between 1 and 100.
class Prime {
    public static void main(String args[]) {
        int i, j;
        boolean isprime;

        for(i=1; i < 100; i++) {
            isprime = true;

            // see if the number is evenly divisible
            for(j=2; j <= i/2; j++)
                // if it is, then its not prime
                if((i%j) == 0) isprime = false;

            if(isprime)
                System.out.println(i + " is prime.");
        }
    }
}

