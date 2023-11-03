import java.util.Comparator;

/**
 * A sorting algorithm that recursively partitions a collection into small
 * and large values, then sorts the partitioned halves.
 *
 * @author Jayson Kunkel
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

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
  } // swap (T[], int, int)

  /**
   * Select a pivot and partition the subarray from [lb .. ub) into 
   * the following form.
   *
   * <pre>
   * ---+-----------------+-+----------------+---
   *    | values <= pivot |p| values > pivot |
   * ---+-----------------+-+----------------+---
   *    |                 |                  |
   *    lb                pivotLoc           ub
   * </pre>
   *
   * @return pivotLoc.
   */
  public static <T> int partition(T[] arr, Comparator<? super T> comparator, int lb, int ub) {

    // singleton arrays are sorted
    if(ub-lb <= 1){
      return lb;
    } // if

    // set small and large indices
    int small = lb + 1;
    int large = ub;

    // determine a pivot point, the midpoint in this case
    int mid = lb + (ub - lb) / 2;
    //System.out.println("pivot: " + arr[mid]);
    // swap the pivot to the front of the array
    swap(arr, lb, mid);

    // while the large and small indices are not in the same location
    while (large != small) { 
      // if first unprocessed element is greater than pivot, place it with the large elements
      if(comparator.compare(arr[small], arr[lb]) > 0){
        swap(arr, small, large - 1);
        large--;
      } // if
      // if it's smaller than or equal to the pivot, it is in the correct place
      else{
        small++;
      } // else
    } // while

    // swap pivot to the end of the small section
    swap(arr, lb, large - 1);

    // return position of the pivot
    return large-1;

  } // partition (T[], Comparator<? super T>, int, int)

  /**
   * Sort an array using the quick sort algorithm.
   * 
   * Preconditions: Vals does not contain null values.
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> comparator) {
    sort(values, comparator, 0, values.length);
  } // sort (T[], Comparator<? super T>, int, int)

  /**
   * Sort the values in indices [lb..ub) of values using order to compare values.
   */
  private static <T> void sort(T[] values, Comparator<? super T> comparator, int lb, int ub) {
    // Subarrays of one element or fewer are sorted.
    if (lb >= ub-1) {
      return;
    } // if
    else {
      // determine the pivot and sort both halves of the array
      int mid = partition(values, comparator, lb, ub);
      sort(values, comparator, lb, mid);
      sort(values, comparator, mid+1, ub);
    } // else
  } // sort(T[], Comparator<? super T>, int, int)

} // class Quicksort
