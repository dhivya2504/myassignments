package week4.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {

	public static void main(String[] args) {
		Integer array1[] = { 3, 2, 11, 4, 6, 7 };
		Integer array2[] = { 1, 2, 8, 4, 9, 7 };
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(array1));
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(array2));
		System.out.println(list1);
		System.out.println(list2);

		for (int i = 0; i < list1.size(); i++) {
			Integer value = list1.get(i);

			if (list2.contains(value)) {
				System.out.println(value);

			}
		}
	}

}
