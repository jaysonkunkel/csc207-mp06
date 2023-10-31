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
   */
  @Override
  public <T> void sort(T[] vals, Comparator<? super T> comparator) {
    sort(vals, comparator, 0, vals.length-1);
  } // sort

  public static <T> void sort(T[] vals, Comparator<? super T> comparator, int lo, int hi){

    if(lo < hi){

      int mid = (lo + hi)/2;

      sort(vals, comparator, lo, mid);
      sort(vals, comparator, mid+1, hi);

      merge(vals, lo, mid, hi, comparator);
    }

  } // sort

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

    T[] merged = java.util.Arrays.copyOfRange(vals, lo, hi+1);

    System.out.println(Arrays.toString(merged));

    int left = lo;
    int right = mid+1;
    int current = lo;

    // Merge the left and right halves
    while(left <= lo + (mid-lo) && right <= lo + (hi - lo)){
      if(comparator.compare(merged[left-lo], merged[right-lo]) <= 0){
        vals[current] = merged[left-lo];
        left++;
      }
      else{
        vals[current] = merged[right-lo];
        right++;
      }
      current++;
    }

    // Copy over remaining elements, if any
    while(left <= lo + (mid-lo)){
      vals[current++] = merged[left++ - lo];
    }

    while(right < hi - mid){
      vals[current++] = merged[right++ - lo];
    }
  } // merge
  
} // class MergeSort
