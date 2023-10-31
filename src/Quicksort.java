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

    if(ub-lb <= 1){
      return lb;
    }

    // set small and large indices
    int small = lb + 1;
    int large = ub;

    // determine a pivot point, midpoint here
    //int mid = (lb + ub) / 2;
    //int mid = 0;

    int mid = lb + (ub - lb) / 2;
    System.out.println("pivot: " + arr[mid]);
    swap(arr, lb, mid);


    while (large != small) { 
      // if first unprocessed element is greater than pivot
      if(comparator.compare(arr[small], arr[lb]) > 0){
        swap(arr, small, large - 1);
        large--;
      } 
      else{
        small++;
      }
    }

    // swap pivot to the end of the small section
    swap(arr, lb, large -1);

    // return position of the pivot
    return large-1;

  } // partition (T[], Comparator<? super T>, int, int)

  public static <T> void swap (T[] vals, int i, int j){
    T temp = vals[i];
    vals[i] = vals[j];
    vals[j] = temp;
  } // swap (T[], int, int)


  /**
   * Sort the values in indices [lb..ub) of values using order to compare values.
   */
  private static <T> void sort(T[] values, Comparator<? super T> comparator, int lb, int ub) {
    // Subarrays of one element or fewer are sorted.
    if (lb >= ub-1) {
      return;
    } else {
      int mid = partition(values, comparator, lb, ub);
      sort(values, comparator, lb, mid);
      sort(values, comparator, mid+1, ub);
    } // if/else
  } // sort(T[], Comparator, int, int)

  @Override
  public <T> void sort(T[] values, Comparator<? super T> comparator) {
    sort(values, comparator, 0, values.length);
  } // sort

} // class Quicksort
