/** 
 * 
 */
package allsorts;

import java.util.Random;

/**
 * This class contain all the sorting algorithm (Insertion, Selection, Bubble, Merge, and Quick Sorts)
 * 
 * @author Viet Nguyen
 * Fall 2015
 * Dr. Ali
 * 
 */
public class SortingAlgorithms {

	/**
	 * Main method for testing all the sorts.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//String[] array = {"1","3","7","5","4","0", "8", "66", "19", "099999", "1321321313213"}; //, 18, 35, 1, 3, 6,8,11,2,6};
		String[] array = new String[100];
		for (int i = 0; i < 100; i++) {
			array[i] = new Random().nextInt(1000) + "";
		}
				
		insertionSort(array);
		//selection(array);
		//bubble(array);
		//mergeSort(array, 0, 10);
		//quickSort(array, 0, array.length-1);
		
		// output test
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		
	}
	
	// for String Arrays
	/**
	 * This will sort the array following the Insertion Sort algorithm
	 * 
	 * @param list is the array to pass in for sorting
	 */
	public static void insertionSort (String[] list) {
		
		for (int i = 0; i < list.length; i++) {
			
			int j = i;
			while (j > 0) {
				if (list[j].compareTo(list[j-1]) > 0) {
					break;
				} else {
					String temp = list[j-1];
					list[j-1] = list[j];
					list[j] = temp;
					j--;
				}
			}
		}
		
	}
	
	/**
	 * This will sort the array following the Selection Sort Algorithm
	 * 
	 * @param list is the array to pass in for sorting
	 */
	public static void selectionSort(String[] list) {
		
		for (int i = 0; i < list.length; i++) {
			
			for (int j = i+1 ; j < list.length; j++) {
				if (list[j].compareTo( list[i]) < 0) {
					String temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
						
		}
	}
	
	/**
	 * This will sort the array following the Bubble Sort Algorithm
	 * 
	 * @param list is the array to pass in for sorting
	 */
	public static void bubbleSort(String[] list) {
		
		for (int i = list.length; i > 0; i--) {			
			
			for (int j = 0; j < i - 1; j++) {
				String temp = list[j];
				if (list[j].compareTo(list[j+1]) > 0) {
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * This will sort the array following the Merge Sort Algorithm
	 * 
	 * @param a is the array to pass in for sorting
	 * @param start is started index of array
	 * @param end is ending index of array
	 */
	public static void mergeSort(String[] a, final int start, final int end) {
		
		if (end - start > 1) {
			int leftEnd = (end + start) / 2;
			int rightStart = leftEnd + 1;
			
			// recursive split left half;
			mergeSort(a, start, leftEnd);
			// recursive split right half;
			mergeSort(a, rightStart, end);
			
			merge(a, start, leftEnd, rightStart, end);
			
		} else if (end - start == 1) {
			if (a[start].compareTo(a[end]) > 0) {
				String temp = a[start];
				a[start] = a[end];
				a[end] = temp;
			}

		}
	}
	
	/**
	 * This will sort the array following the Quick Sort Algorithm
	 * 
	 * @param a is the array to pass in for sorting
	 * @param start start is started index of array
	 * @param end end is ending index of array
	 */
	public static void quickSort(String[] a, int start, int end) {
		
		if (start < end) {
			int pivot = end;
			int current = start;
			while (current < pivot) {
				if (a[current].compareTo(a[pivot]) < 0)  
					current ++;
				else {
					String temp = a[pivot];
					a[pivot] = a[current];
					pivot--;
					a[current] = a[pivot];
					a[pivot] = temp;
					
				}
			}
			// recursive left piece
			quickSort(a, start, current - 1);
			// recursive right piece
			quickSort(a, current + 1, end);
		}
		
	}
	
	/**
	 * This method merge 2 piece of array passing in
	 * 
	 * @param a
	 * @param leftStart is left starting index
	 * @param leftEnd is left ending index
	 * @param rightStart is right starting index
	 * @param rightEnd is right ending index
	 */
	public static void merge(String[] a, int leftStart, int leftEnd, int rightStart, int rightEnd) {
		
		int indexB = 0;
		int indexC = 0;
		String[] b = new String[leftEnd - leftStart + 1];
		String[] c = new String[rightEnd - rightStart + 1];
		for (int j = leftStart; j <= leftEnd; j++ ) {
			b[indexB] = a[j];
			indexB++;
		}
		
		for (int h = rightStart; h <= rightEnd; h++ ) {
			c[indexC] = a[h];
			indexC++;
		}
		
		// test
		/*for (int i = 0; i < b.length;i++)
			System.out.print(b[i] + " ");
		System.out.println();
		for (int i = 0; i < c.length;i++)
			System.out.print(c[i] + " ");
		System.out.println();*/
		
		indexB = 0;
		indexC = 0;
		for (int i = leftStart; i <= rightEnd; i++) {
			
			if (indexB < b.length && indexC < c.length) { // if both arrays still have elements
				if (b[indexB].compareTo(c[indexC]) <= 0) {
					a[i] = b[indexB];
					indexB++;
				} else {
					a[i] = c[indexC];
					indexC++;
				}
			} else { // either array have no elements
				if (indexB < b.length) {
					a[i] = b[indexB];
					indexB++;
				} else {
					a[i] = c[indexC];
					indexC++;
				}
			}
		}
	}
	
	/************************************* for integer array ************************************************/
	
	/*public static void quickSort(int[] a, int start, int end) {
		
		if (start < end) {
			int pivot = end;
			int current = start;
			while (current < pivot) {
				if (a[current] < a[pivot]) 
					current ++;
				else {
					int temp = a[pivot];
					a[pivot] = a[current];
					pivot--;
					a[current] = a[pivot];
					a[pivot] = temp;
					
				}
			}
			// recursive left piece
			quickSort(a, start, current - 1);
			// recursive right piece
			quickSort(a, current + 1, end);
		}
		
	}
	
	public static void insertionSort (int[] list) {
		
		for (int i = 0; i < list.length; i++) {
			
			int j = i;
			while (j > 0) {
				if (list[j] > list[j-1]) {
					break;
				} else {
					int temp = list[j-1];
					list[j-1] = list[j];
					list[j] = temp;
					j--;
				}
			}
		}
		
	}
	
	public static void selectionSort(int[] list) {
		
		for (int i = 0; i < list.length; i++) {
			
			for (int j = i+1 ; j < list.length; j++) {
				if (list[j] < list[i]) {
					int temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
						
		}
	}
	
	public static void bubbleSort(int[] list) {
		
		for (int i = list.length; i > 0; i--) {			
			
			for (int j = 0; j < i - 1; j++) {
				int temp = list[j];
				if (list[j] > list[j+1]) {
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			}
		}
	}
	
	public static void mergeSort(int[] a, final int start, final int end) {
		
		if (end - start > 1) {
			int leftEnd = (end + start) / 2;
			int rightStart = leftEnd + 1;
			
			// recursive split left half;
			mergeSort(a, start, leftEnd);
			// recursive split right half;
			mergeSort(a, rightStart, end);
			
			merge(a, start, leftEnd, rightStart, end);
			
		} else if (end - start == 1) {
			if (a[start] > a[end]) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
			}

		}
	}
	
	public static void merge(int[] a, int leftStart, int leftEnd, int rightStart, int rightEnd) {
		
		int indexB = 0;
		int indexC = 0;
		int[] b = new int[leftEnd - leftStart + 1];
		int[] c = new int[rightEnd - rightStart + 1];
		for (int j = leftStart; j <= leftEnd; j++ ) {
			b[indexB] = a[j];
			indexB++;
		}
		
		for (int h = rightStart; h <= rightEnd; h++ ) {
			c[indexC] = a[h];
			indexC++;
		}
		
		// test
		for (int i = 0; i < b.length;i++)
			System.out.print(b[i] + " ");
		System.out.println();
		for (int i = 0; i < c.length;i++)
			System.out.print(c[i] + " ");
		System.out.println();
		
		indexB = 0;
		indexC = 0;
		for (int i = leftStart; i <= rightEnd; i++) {
			
			if (indexB < b.length && indexC < c.length) { // if both arrays still have elements
				if (b[indexB] <= c[indexC]) {
					a[i] = b[indexB];
					indexB++;
				} else {
					a[i] = c[indexC];
					indexC++;
				}
			} else { // either array have no elements
				if (indexB < b.length) {
					a[i] = b[indexB];
					indexB++;
				} else {
					a[i] = c[indexC];
					indexC++;
				}
			}
		}
	}*/
}
