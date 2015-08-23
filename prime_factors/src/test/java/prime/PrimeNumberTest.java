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
    int[] numbers = new int[]{2,3,5,7,11};
    for(int primeNumber: numbers) {
      assertThat(PrimeNumber.isPrimeNumber(primeNumber), is(true));
    }
  }

  @Test
  public void test_basic_non_prime_numbers() {
    int[] numbers = new int[]{4,6,8,9,10};
    for(int nonPrimeNumber: numbers) {
      assertThat(PrimeNumber.isPrimeNumber(nonPrimeNumber), is(false));
    }
  }

}
