import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import java.util.Comparator;

/**
 * Tests of Sorter objects.
 *
 * @author Your Name
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  /**
   * Compare integers.
   */
  static Comparator<Integer> compareInts = (x,y) -> x == y ? 0 : x < y ? -1 : 1;

  /**
   * Compare strings.
   */
  static Comparator<String> compareStrings = (x,y) -> x.compareTo(y);

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, compareStrings);
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, compareStrings);
    assertArrayEquals(original, expected);
  } // reverseOrderedStringTest

  @Test
  public void zeroElementStringTest(){
    String[] original = {};
    String[] expected = original.clone();
    sorter.sort(original, compareStrings);
    assertArrayEquals(expected, expected);
  } // zeroElementStringTest

  @Test
  public void singleElementStringTest(){
    String[] original = {"hello"};
    String[] expected = original.clone();
    sorter.sort(original, compareStrings);
    assertArrayEquals(original, expected);
  } // singleElementStringTest

  @Test
  public void unorderedStringTest(){
    String[] original = { "bravo", "foxtrot", "charlie", "alpha", "delta" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, compareStrings);
    assertArrayEquals(original, expected);
  } // unorderedStringTest

  @Test
  public void unorderedStringWithEmptyTest(){
    String[] original = { "bravo", "", "foxtrot", "", "charlie", "", "alpha", "", "delta" };
    String[] expected = { "", "", "", "", "alpha", "bravo", "charlie", "delta", "foxtrot"};
    sorter.sort(original, compareStrings);
    assertArrayEquals(original, expected);
  } //unorderedStringWithEmptyTest

  @Test
  public void orderedIntegerTest() {
    Integer[] original = { 1, 2, 3, 4, 5, 6};
    Integer[] expected = original.clone();
    sorter.sort(original, compareInts);
    assertArrayEquals(original, expected);
  } // orderedIntegerTest

  @Test
  public void reverseOrderedIntegerTest() {
    Integer[] original = { 6, 5, 4, 3, 2, 1 };
    Integer[] expected = { 1, 2, 3, 4, 5, 6 };
    sorter.sort(original, compareInts);
    assertArrayEquals(original, expected);
  } // reverseOrderedIntegerTest

  @Test
  public void zeroElementIntegerTest(){
    Integer[] original = {};
    Integer[] expected = original.clone();
    sorter.sort(original, compareInts);
    assertArrayEquals(expected, expected);
  } // zeroElementIntegerTest

  @Test
  public void singleElementIntegerTest(){
    Integer[] original = {1};
    Integer[] expected = original.clone();
    sorter.sort(original, compareInts);
    assertArrayEquals(original, expected);
  } // singleElementIntegerTest

  @Test
  public void unorderedIntegerTest(){
    Integer[] original = { 2, 6, 3, 1, 4, 5 };
    Integer[] expected = { 1, 2, 3, 4, 5, 6};
    sorter.sort(original, compareInts);
    assertArrayEquals(original, expected);
  } // unorderedIntegerTest

  @Test
  public void largeArrayTest(){
    int size = 100000000;
    Integer[] original = new Integer[size];
    for(int i = 0; i < size; i++){
      original[i] = size - i - 1;
    }
    Integer[] expected = new Integer[size];
    for(int i = 0; i < size; i++){
      expected[i] = i;
    }
    sorter.sort(original, compareInts);
    assertArrayEquals(original, expected);
  } // largeArrayTest

} // class SortTester
