package prime;

public class PrimeNumber {

  static public boolean isPrimeNumber(int number) {
    if (number < 2 ) {
      return false;
    }
    else {
      /* for(int divisor = number-1; divisor > 2; divisor++ ) { */
      int divisor = 2;
      while(divisor < number) {
        if ((number % divisor) == 0) {
          return false;
        }
        divisor++;
      }
      return true;
    }
  }

}
