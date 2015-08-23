package prime;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class PrimeFactorTest {

  @Test
  public void zero_has_no_primefactors() {
    List<Integer> primFactors = PrimeFactors.determine(0);
    assertThat(primFactors, hasSize(0));
  }

  @Test
  public void one_has_no_primefactors() {
    List<Integer> primFactors = PrimeFactors.determine(1);
    assertThat(primFactors, hasSize(0));
  }

  @Test
  public void two_has_itself_as_primefactors() {
    List<Integer> primFactors = PrimeFactors.determine(2);
    assertThat(primFactors, hasSize(1));
    assertThat(primFactors.get(0), equalTo(new Integer(2)));
  }

  @Test
  public void primeFactors_of_4() {
    List<Integer> primFactors = PrimeFactors.determine(4);
    assertThat(primFactors, hasSize(2));
    assertThat(primFactors.get(0), equalTo(new Integer(2)));
    assertThat(primFactors.get(1), equalTo(new Integer(2)));
  }

  @Test
  public void primeFactors_of_6() {
    List<Integer> primFactors = PrimeFactors.determine(6);
    assertThat(primFactors, hasSize(2));
    assertThat(primFactors.get(0), equalTo(new Integer(2)));
    assertThat(primFactors.get(1), equalTo(new Integer(3)));
  }

  @Test
  public void primeFactors_of_8() {
    List<Integer> primFactors = PrimeFactors.determine(8);
    assertThat(primFactors, hasSize(3));
    assertThat(primFactors.get(0), equalTo(new Integer(2)));
    assertThat(primFactors.get(1), equalTo(new Integer(2)));
    assertThat(primFactors.get(2), equalTo(new Integer(2)));
  }

  @Test
  public void primeFactors_of_9() {
    List<Integer> primFactors = PrimeFactors.determine(9);
    assertThat(primFactors, hasSize(2));
    assertThat(primFactors.get(0), equalTo(new Integer(3)));
    assertThat(primFactors.get(1), equalTo(new Integer(3)));
  }

  @Test
  public void primeFactors_of_120() {
    List<Integer> primFactors = PrimeFactors.determine(120);
    assertThat(primFactors, hasSize(5));
    assertThat(primFactors.get(0), equalTo(new Integer(2)));
    assertThat(primFactors.get(1), equalTo(new Integer(2)));
    assertThat(primFactors.get(2), equalTo(new Integer(2)));
    assertThat(primFactors.get(3), equalTo(new Integer(3)));
    assertThat(primFactors.get(4), equalTo(new Integer(5)));
  }


}
