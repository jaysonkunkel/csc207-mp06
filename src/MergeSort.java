import java.util.Comparator;
import java.util.Arrays;

/**
 * A sorting algorithm that divides a collection in half, recursively
 * sorts both halves, and merges them back together.
 *
 * @author Jayson Kunkel
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  // +------------------+--------------------------------------------
  // | Exported methods |
  // +------------------+

  /**
   * Sort an array using the merge sort algorithm.
   * 
   * Preconditions: Vals does not contain null values.
   */
  @Override
  public <T> void sort(T[] vals, Comparator<? super T> comparator) {
    sort(vals, comparator, 0, vals.length);
  } // sort

  /**
   * Sort the values in indices [lb..ub) of values using order to compare values.
   */
  public static <T> void sort(T[] vals, Comparator<? super T> comparator, int lo, int hi){

    // if the array is not a singleton
    if(hi - lo >= 2){

      // calculate the midpoint 
      int mid = (lo + hi)/2;

      // sort both halves of the array
      sort(vals, comparator, lo, mid);
      sort(vals, comparator, mid, hi);

      // merged both sorted halves of the array
      merge(vals, lo, mid, hi, comparator);
    } // if
  } // sort T[], Comparator<? super T>, int, int)

  // +-----------------+---------------------------------------------
  // | Local utilities |
  // +-----------------+

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {

    // create a copy of vals
    T[] merged = java.util.Arrays.copyOfRange(vals, lo, hi);

    //System.out.println(Arrays.toString(merged));

    // initialize the left and right counters for vals
    // initialize the current counter for merged
    int left = lo;
    int right = mid;
    int current = 0;

    // Merge the left and right halves

    // while the left and right counters are within their subarrays
    while(left < mid && right < hi){
      // compare the first element in each subarray and insert the smallest element
      if(comparator.compare(vals[left], vals[right]) <= 0){
        merged[current] = vals[left];
        left++;
      } // if
      else{
        merged[current] = vals[right];
        right++;
      } // else
      current++;
    } // while

    // Copy over remaining elements, if any

    // while elements remain in the left subarray, copy them over
    while(left < mid){
      merged[current++] = vals[left++];
    } // while

    // while elements remain in the right subarray, copy them over
    while(right < hi){
      merged[current++] = vals[right++];
    } // while

    // copy elements in temporary array back into original array
    for (int i = 0; i < current; i++) {
      vals[lo + i] = merged[i];
    } // for

  } // merge (T[], int, int, int, Comparator<? super T>)
  
} // class MergeSort