package prime;

import java.util.*;

public class PrimeFactors {

  static public List<Integer> determine(int number) {
    if (number < 2 ) {
      return new ArrayList<>();
    }
    List<Integer> primeNumbers = new ArrayList<>();
    for(int potentialPrimeNumber = 2; potentialPrimeNumber <= number; potentialPrimeNumber++) {
      if (PrimeNumber.isPrimeNumber(potentialPrimeNumber)) {
        primeNumbers.add(new Integer(potentialPrimeNumber));
      }
    }
    List<Integer> primeFactors = new ArrayList<>();
    Integer dividedNumber = new Integer(number);
    for(Integer potentialPrimeNumber: primeNumbers) {

      while (dividedNumber % potentialPrimeNumber == 0) {
        primeFactors.add(potentialPrimeNumber);
        dividedNumber = dividedNumber / potentialPrimeNumber;
      }
    }
    return primeFactors;
  }

}
