package week4.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Collection {

	public static void main(String[] args) {
		  String[] companies = {"HCL", "Wipro", "Aspire Systems", "CTS"};
		  List<String> list=new ArrayList<String>()	;
		 for (String company : companies) {
			list.add(company);
		}
	Collections.sort(list);
	
	Collections.reverse(list);
	System.out.println(list);
	}

}
