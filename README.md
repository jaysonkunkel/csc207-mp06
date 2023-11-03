# csc207-mp06

Mini Project 6: Sorting Out Sorting

This mini project contains implementations of four sorting algorithms--insertion sort, merge sort, 
quicksort, and my own sort--each of which implement a generic Sorter interface.

Members:
  Jayson Kunkel

Acknowledgements:
  The merge method in MergeSort.java was originally implemented by myself and Lydia Ye in class.
    It has since changed for this project.
  The partition method in Quicksort.java was implemented by myself and Kevin Johansen in class.
  Thank you to everyone who stayed up late working with me in the classroom this week.
    Especially those who laughed about Bogosort with me on Wednesday.

Resources used: 
  Sorting notes and labs:
    I frequently referenced the labs and class notes for each sorting algorithm throughout this project.
  StackOverflow:
    I consulted StackOverflow for questions pertaining to the runtime and performance of sorting algorithms.

Note:
  I chose not to utilize ChatGPT on this project. It turns out it's difficult to implement a 'new' sorting
  algorithm without taking pieces of popular existing algorithms. I discovered too late that my idea to 
  switch to insertion sort for small input sizes mirrored the java Arrays.sort() method. Maybe in the future I
  will attempt to create a 'new' algorithm in a different manner.