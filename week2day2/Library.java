package week2day2;

public class Library {
	
	public String addBook(String bookTitle) {
		System.out.println("Book added successfully");
		return bookTitle;

	}
	public void issueBook() {
		System.out.println("Book issued successfully");
		
    }
	public static void main(String[] args) {
		
		Library object=new Library();
		String addBook=object.addBook("the java");
		System.out.println(addBook);
		object.issueBook();
	}

}
