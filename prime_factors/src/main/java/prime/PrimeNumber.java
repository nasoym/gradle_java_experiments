package prime;

public class PrimeNumber {

  static public boolean isPrimeNumber(int number) {
    return fIsPrimeNumber(number);
  }

  static private boolean fIsPrimeNumber(int number) {
    if (isSpecialNumber(number)) {
      return false;
    }
    else {
      if (isDividableByAnyLargerOne(number, number-1)) {
        return false;
      }
      return true;
    }
  }

  static private boolean isDividableByAnyLargerOne(int number, int divisor) {
    if (divisor == 1) {
      return false;
    }
    if (isDividableBy(number, divisor)) {
      return true;
    }
    return isDividableByAnyLargerOne(number, divisor-1);
  }

  static private boolean isSpecialNumber(int number) {
    return number < 2;
  }

  static private boolean isDividableBy(int number, int divisor) {
    return (number % divisor) == 0;
  }

  static private boolean IIsPrimeNumber(int number) {
    if (number < 2 ) {
      return false;
    }
    else {
      int divisor = number - 1;
      while(divisor >= 2) {
        if ((number % divisor) == 0) {
          return false;
        }
        divisor--;
      }
      return true;
    }
  }

}
