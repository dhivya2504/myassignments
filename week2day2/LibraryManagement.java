package week2day2;

public class LibraryManagement {

	public static void main(String[] args) {
		
		Library object=new Library();
		String addBook=object.addBook("Record");
		System.out.println(addBook);
		object.issueBook();

	}

}
