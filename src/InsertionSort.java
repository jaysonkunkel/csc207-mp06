import java.util.Comparator;

/**
 * A sorting algorithm that divides a collection into sorted and unsorted values, and
 * "inserts" each unsorted value into its correct place in the sorted values.
 *
 * @author Jayson Kunkel
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Swaps two elements in an array.
   */
  public static <T> void swap (T[] vals, int i, int j){
    T temp = vals[i];
    vals[i] = vals[j];
    vals[j] = temp;
  } // swap (T[] int, int)

  /**
   * Sort an array using the insertion sort algorithm.
   * 
   * Preconditions: Vals does not contain null values.
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> comparator) {
    sort(values, comparator, 0, values.length);
  } // sort(T[], Comparator<? super T>

   /**
   * Sort the values in indices [lb..ub) of values using order to compare values.
   */
  private static <T> void sort(T[] values, Comparator<? super T> comparator, int lb, int ub){

    // initialize the counter; one-element subarrays are sorted
    int i = lb + 1;

    while(i < ub){
      // if the current element is smaller than the previous element
      if(comparator.compare(values[i], values[i-1]) <= 0){

        int j = 0;
        // repeatedly swap out of place element to the left until it is in place
        while(j <= i){
          if(comparator.compare(values[i], values[j]) <= 0){
            swap(values, i, j);
          } // if
          j++;
        } // while
      } // if
      i++;
    } // while
  } // sort(T[], Comparator<? super T>, int, int)

} // class InsertionSort
