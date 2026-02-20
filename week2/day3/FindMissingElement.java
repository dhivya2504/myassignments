package week2.day3;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindMissingElement {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 3, 2, 8, 6, 7 };
		int missingNumber = findMissingNumber(arr);
		System.out.println("Missing Number: " + missingNumber);
	}

	public static int findMissingNumber(int[] arr) {

		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] != i + 1) {

				return i + 1;
			}
		}

		return arr.length + 1;
	}
}