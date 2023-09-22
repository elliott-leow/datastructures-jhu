package hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hw1.Task.twoSum;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TaskTest {

  @Test
  @DisplayName("twoSum works for input {2, 7, 11, 15} and target 9")
  public void worksForProvidedSample() {
    int[] input = new int[]{2, 7, 11, 15};
    int target = 13;
    int[] expected = new int[]{0, 2};
    int[] actual = twoSum(input, target);
    assertArrayEquals(expected, actual);
  }

  // You are not expected to write tests for this homework, but feel free to do so!
}
