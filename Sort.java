/*****************************************************/
/*** Purpose:                                      ***/
/***                                               ***/
/***     Initial Author: Jason Steggles 20/09/17   ***/
/***     Extended by: Your Name    Date            ***/
/*****************************************************/

import java.io.*;
import java.text.*;
import java.util.*;

public class Sort {

	/** Array of integers to sort **/
	private int[] A;

	/** Size of the array **/
	private int size;

	/** Number of elements actually used in array **/
	private int usedSize;

	/** Global variables for counting sort comparisons **/
	public int compIS;
	/** Global comparison count for Insertion Sort **/
	public int compQS;
	/** Global comparison count for Quicksort **/
	public int compNewS;

	/** Global comparison count for new sort **/

	/*****************/
	/** Constructor **/
	/*****************/
	Sort(int max) {
		/** Initialiase global sort count variables **/
		compIS = 0;
		compQS = 0;
		compNewS = 0;

		/** Initialise size variables **/
		usedSize = 0;
		size = max;

		/** Create Array of Integers **/
		A = new int[size];
	}

	/*********************************************/
	/*** Read a file of integers into an array ***/
	/*********************************************/
	public void readIn(String file) {
		try {
			/** Initialise loop variable **/
			usedSize = 0;

			/** Set up file for reading **/
			FileReader reader = new FileReader(file);
			Scanner in = new Scanner(reader);

			/** Loop round reading in data while array not full **/
			while (in.hasNextInt() && (usedSize < size)) {
				A[usedSize] = in.nextInt();
				usedSize++;
			}

		} catch (IOException e) {
			System.out.println("Error processing file " + file);
		}
	}

	/**********************/
	/*** Display array ***/
	/**********************/
	public void display(int line, String header) {
		/*** Integer Formatter - three digits ***/
		NumberFormat FI = NumberFormat.getInstance();
		FI.setMinimumIntegerDigits(3);

		/** Print header string **/
		System.out.print("\n" + header);

		/** Display array data **/
		for (int i = 0; i < usedSize; i++) {
			/** Check if new line is needed **/
			if (i % line == 0) {
				System.out.println();
			}

			/** Display an array element **/
			System.out.print(FI.format(A[i]) + " ");
		}
	}

	// -------------------------------------------------------------------------------------------//
	// ---------------------------THIS IS THE START OF MY WORK------------------------------------//
	// -------------------------------------------------------------------------------------------//
	
	/**
	 * Arthour : Callum Matthew Simpson
	 * Student ID: b6030326
	 */

	/**
	 * Performs insertion sort onto the array. Begin with left most array and invoke
	 * an insert to insert each element into the correct postion.
	 * 
	 */
	public void insertion() {

		// set N to be the size of that array
		int N = usedSize;

		// Goes through every value in the array to perform sorting
		for (int i = 1; i <= N - 1; i++) {

			// Set the value which we are going to comparing to the rest of the array.
			int key = A[i];

			// set J to be the current array element which we are going to start the search
			int j = i;

			// while there is a value currently greater than the key value
			while (j > 0 && key < A[j - 1]) {

				// move the array position you are checking to one to the left
				A[j] = A[j - 1];

				// increase j by 1;
				j = j - 1;

				// increase compIS by 1
				compIS++;

			}
			
			//Still need to increase the compator by 1 if while loop fails.
			compIS++;
			
			// set the current array position J element to be the key value as that would be
			// the correct place for it.
			A[j] = key;

		}
	}

	/**
	 * perform quick sort on the array selects a pivot array , partions the array
	 * into 3 parts and then applys the quicksort algorithms
	 */
	public void quickSort() {

		// Set up the quick sort algorithm to use the full array
		// 0 is the 1st value in the array and usedSize-1 will get the last value in the
		// array.
		quick(0, usedSize - 1);

	}

	/**
	 * This method will work recursive, taking in a left pivot and a right pivots to
	 * sort the array.
	 * 
	 * @param quickLeft
	 *            = the left value
	 * @param quickRight
	 *            = the right value
	 */
	public void quick(int quickLeft, int quickRight) {

		// if the right pivot is larger than the left array pivot
		if (quickRight > quickLeft) {

			// set p to be the results of the partitioning method
			// this will take in the left pivot and a right pivot entered into the quick
			// method
			int partion = partitioning(quickLeft, quickRight);

			// Perform the quick sort method with the left pivot and with the right
			// pivot being replaced by partitioning method result -1
			quick(quickLeft, partion - 1);

			// Perform the quick sort method with the right pivot and with the left
			// pivot being replaced by partitioning method result + 1
			quick(partion + 1, quickRight);

		}

	}

	/**
	 * a partitioning algorithm that takes in a left and right array pointers
	 * 
	 * @param partLeft
	 *            the left most value of the current part of the array
	 * @param partRight
	 *            the right most value of the current part of the array
	 * @return the left pivot value
	 */
	public int partitioning(int partLeft, int partRight) {

		// set the pivot to be the value that is in array point R
		int pivot = A[partRight];

		// pl is the left array pointer
		int pointerLeft = partLeft;

		// pR is the right array pointer
		int pointerRight = partRight;

		// while the right value is grater than the left value
		while (pointerLeft < pointerRight) {

			
			// the value at array postion pL is greater than the pivot
			while (A[pointerLeft] < pivot) {

				// increase compQS by 1
				compQS++;
				// increase pL so that the while loop checks if the next element in the array is
				// greater than the pivot
				pointerLeft = pointerLeft + 1;
			}
			//the counter must increase by one if the test fails 
			compQS++;

			while (A[pointerRight] >= pivot && pointerRight > partLeft) {

				// increase compQS by 1 as a comparison has been made 
				compQS++;

				// increase pR by 1
				pointerRight = pointerRight - 1;
			}
			//the counter must increase by one when the test fails 
			compQS++;

			// if the left pivot is less than the right pivot.
			if (pointerLeft < pointerRight) {

				// swap the left pivot value with the right pivot value.
				swap(pointerLeft, pointerRight);


			}

		}

		// Swap the value at pL with the value at R
		swap(pointerLeft, partRight);
		

		// return the value current stored in pL;
		return pointerLeft;

	}

	/**
	 * 
	 * @param swapLeft
	 *            the left value we want to swap
	 * @param swapRight
	 *            the right value we want to swap
	 */
	// A method to swap one value with another
	public void swap(int swapLeft, int swapRight) {

		// set swap value to the value at position sL in the array.
		int swapvalue = A[swapLeft];
		// set the value at array A position sL to be equal to the value at sR
		A[swapLeft] = A[swapRight];
		// set the value at array A position sR to be equal to swap value, the previous
		// value at array position sL.
		A[swapRight] = swapvalue;

	}

	/**
	 * Performs a newSort onto an array of numbers.
	 */
	public void newSort() {

		// set position to be equal to zero
		int pos = 0;

		// while position is less than the used size of the array
		while (pos < usedSize) {

			// set min to be the value gotten from the method findMinFrom ( the smallest
			// value in the array);
			int min = findMinFrom(pos);
			

			// a for loop that shall continue until looping until iNew is greater or equal
			// to usedSize -1
			for (int iNew = pos; iNew <= usedSize - 1; iNew++) {

				// if the position at iNew in the array A is equivalent to min 
				if (A[iNew] == min) {
					
					// as array value are compared, increase the comparator by one
					compNewS++;

					// swap iNew with pos
					swap(iNew, pos);
				
					// increase pos by one.
					pos = pos + 1;

				}

				// A comparison has been made so the counter must be called.
				else {
					//increase compNewS by 1
					compNewS++;

				}

			}

		}

	}

	/**
	 * A method to find the smallest value in the array
	 * 
	 * @param pos
	 *            = A position in the array
	 * @return min - the smallest value in the array.
	 */
	private int findMinFrom(int pos) {

		// set min to be the value in array A position "pos"
		int min = A[pos];

		// a for loop that shall continue looping until iMin is greater or equal to
		// usedSize
		for (int iMin = pos + 1; iMin <= usedSize - 1; iMin++) {

			// if the position in the array is less than the set minimum value in the array,
			// set it as the new smallest value.
			if (A[iMin] < min) {
				min = A[iMin];
			}

			//The array has been compared in findMinFrom so increase compNewS by 1.
			compNewS++;
		}

		// return the smallest value.
		return min;

	}

}

/** End of Sort Class **/