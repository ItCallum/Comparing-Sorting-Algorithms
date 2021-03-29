
/*************************************************/
/*** Simple test class for Sort class          ***/
/***                                           ***/
/*** Author: Callum Simpson   31/10/2017       ***/
/*** Number: b6030326                          ***/
/*************************************************/

public class TestSort {

	// set the length of the columns
	public static final int DISPLAY_LENGTH = 10;

	public static final int SORT_LENGTH = 100;

	// Constants values for the test numbers
	public static final int ONE = 1;
	public static final int TWO = 2;
	public static final int THREE = 3;
	public static final int FOUR = 4;
	public static final int FIVE = 5;

	// constant values for the file names.
	public static final String TEXTFILE1 = "test1.txt";
	public static final String TEXTFILE2 = "test2.txt";
	public static final String TEXTFILE3 = "test3.txt";
	public static final String TEXTFILE4 = "test4.txt";
	public static final String TEXTFILE5 = "test5.txt";

	public static void main(String[] args) {

		
		/**
		 * NOTE ------------------------------------------------------------
	     * IF YOU WOULD LIKE TO TEST SOMTHING PLEASE FEEL FREE TO REMOVE THE // BEFORE
		 * THE METHODS.
		 * 
		 */

		// fullTest(ONE,TEXTFILE1);

		// fullTest(TWO,TEXTFILE2);

		// fullTest(THREE,TEXTFILE3);

		// fullTest(FOUR,TEXTFILE4);

		// fullTest(FIVE,TEXTFILE5);

		// insertionTest(ONE,TEXTFILE1);

		// insertionTest(TWO,TEXTFILE2);

		// insertionTest(THREE,TEXTFILE3);

		// insertionTest(FOUR,TEXTFILE4);

		// insertionTest(FIVE,TEXTFILE5);

		// quickTest(ONE,TEXTFILE1);

		// quickTest(TWO,TEXTFILE2);

		// quickTest(THREE,TEXTFILE3);

		// quickTest(FOUR,TEXTFILE4);

		// quickTest(FIVE,TEXTFILE5);

		// testNewSort(ONE,TEXTFILE1);

		// testNewSort(TWO,TEXTFILE2);

		// testNewSort(THREE,TEXTFILE3);

		// testNewSort(FOUR,TEXTFILE4);

		// testNewSort(FIVE,TEXTFILE5);
	}

	/**
	 * this method will perform the insertion sort method and then the quick sort
	 * method on the same array of number.
	 * 
	 * @param fullTestNumber
	 *            is the number of the test document we are testing.
	 * @param fileName
	 *            is the name of the file
	 */
	public static void fullTest(int fullTestNumber, String fileName) {

		// create a new Sort class to perform both the
		Sort fullSort = new Sort(SORT_LENGTH);

		// tells us what test we are working on
		System.out.println("\n\nThis is a full test of " + fullTestNumber);

		// read in the array of numbers
		fullSort.readIn(fileName);

		// display the unordered array.
		fullSort.display(DISPLAY_LENGTH, "Unsorted Input Array " + fullTestNumber);

		// run the array through the insertion sort class
		fullSort.insertion();

		// display the full array insertion sorted array
		fullSort.display(DISPLAY_LENGTH, "\nInsertion Sorted Input Array " + fullTestNumber);

		// return the array to its original unordered state.
		fullSort.readIn(fileName);

		// perform quick sort onto the array
		fullSort.quickSort();

		// display the quick sorted array
		fullSort.display(DISPLAY_LENGTH, "\nQuick Sorted Input Array " + fullTestNumber);

		// Show the number of comparison in insertion sort
		System.out.println("\n\nInsertion sort comparison counter: " + fullSort.compIS);
		// show the number of comparisons in quicksort
		System.out.println("Quicksort comparison counter: " + fullSort.compQS);
	}

	/**
	 * this is used to test out insertion sort
	 * 
	 * @param fullTestNumber
	 *            = is the number of the test document we are testing.
	 * @param fileName
	 *            = is the name of the file
	 */
	public static void insertionTest(int fullTestNumber, String fileName) {

		// creat a new sort class size of SORT_LENGTH
		Sort insertionSort = new Sort(SORT_LENGTH);


		// tells us the test number
		System.out.println("\n\nThis is a test of the interstion sort algorithm on file " + fullTestNumber);

		// read in the array text file
		insertionSort.readIn(fileName);

		// Display the unsorted array
		insertionSort.display(DISPLAY_LENGTH, "Unsorted Input Array " + fullTestNumber);

		// perform insertion sort
		insertionSort.insertion();

		// display the insertion sorted array
		insertionSort.display(DISPLAY_LENGTH, "\nInsertion Sorted Input Array " + fullTestNumber);

		// print off the number of comparison.
		System.out.println("\n\nInsertion sort comparison counter: " + insertionSort.compIS);

	}

	/**
	 * this is used to test out quick sort
	 * 
	 * @param quickTestNumber
	 *            = the number of the test document we are testing.
	 * @param fileName
	 *            = the name of the file
	 */
	public static void quickTest(int quickTestNumber, String fileName) {

		// creat a new sort class size of SORT_LENGTH
		Sort quickSort = new Sort(SORT_LENGTH);

		// say what test this is
		System.out.println("\n\nThis is a test of the quick sort algorithm on file " + quickTestNumber);
		// read in the array of numbers
		quickSort.readIn(fileName);
		// display the unsorted array
		quickSort.display(DISPLAY_LENGTH, "Unsorted Input Array " + quickTestNumber);
		// perform quick sort on the algorithm
		quickSort.quickSort();
		// Display the sorted array
		quickSort.display(DISPLAY_LENGTH, "\nQuick Sorted Input Array " + quickTestNumber);
		// tell us the total quick sort comparisons.
		System.out.println("\n\nQuicksort comparison counter: " + quickSort.compQS);
	}

	/**
	 * This is the test for the new sort method
	 * @param newTestNumber  = the number of the test document we are testing.
	 * @param fileName  =  the name of the file
	 */
	public static void testNewSort(int newTestNumber, String fileName) {

		// creat a new sort class size of SORT_LENGTH
		Sort newSort = new Sort(SORT_LENGTH);
		// read in the array text file
		newSort.readIn(fileName);
		// display unsorted array
		newSort.display(DISPLAY_LENGTH, "Unsorted Input Array " + newTestNumber);
		// perform the new sort algoritm
		newSort.newSort();
		// show the sorted array
		newSort.display(DISPLAY_LENGTH, "\nNew sorted Input Array " + newTestNumber);
		// show the number of comparison.
		System.out.println("\nNewsort comparison counter: " + newSort.compNewS);

	}

}/** End of Test class **/