package week4.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.checkerframework.checker.units.qual.Length;

public class SecondLargest {

	public static void main(String[] args) {
		Integer array1[] = { 3, 2, 11, 4, 6, 7 };
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(array1));
		Collections.sort(list1);
		System.out.println(list1);
		System.out.println(list1.get(4));
	}

}
