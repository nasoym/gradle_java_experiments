package prime;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class PrimeNumberTest {

  @Test
  public void zero_and_one_are_no_prime_numbers() {
    assertThat(PrimeNumber.isPrimeNumber(0), is(false));
    assertThat(PrimeNumber.isPrimeNumber(1), is(false));
  }

  @Test
  public void test_basic_prime_numbers() {
    int[] numbers = new int[]{2,3,5,7,11,13,17,19};
    /* 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 …^[2] */
    for(int primeNumber: numbers) {
      assertThat("test prime number: " + primeNumber, PrimeNumber.isPrimeNumber(primeNumber), is(true));
    }
  }

  @Test
  public void test_extended_prime_numbers() {
    int[] numbers = new int[]{23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    for(int primeNumber: numbers) {
      assertThat("test prime number: " + primeNumber, PrimeNumber.isPrimeNumber(primeNumber), is(true));
    }
  }

  @Test
  public void test_basic_non_prime_numbers() {
    int[] numbers = new int[]{4,6,8,9,10,12,14,15,16,18,20};
    for(int nonPrimeNumber: numbers) {
      assertThat("test non prime number: " + nonPrimeNumber, PrimeNumber.isPrimeNumber(nonPrimeNumber), is(false));
    }
  }

}
