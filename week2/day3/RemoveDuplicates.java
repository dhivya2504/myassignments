package week2.day3;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String text = "We learn Java basics as part of java sessions in java week1";
		int count = 0;

		String[] words = text.split(" ");

		for (int i = 0; i < words.length; i++) {

			for (int j = i + 1; j < words.length; j++) {

				if (words[i] != null && words[j] != null && words[i].equalsIgnoreCase(words[j])) {
					words[j] = null;
					count++;
				}
			}
		}
     if (count > 0) {
			
			System.out.println("Expected output: ");
			for (String word : words) {
				if (word != null) {
					System.out.print(word + " ");
				}
			}
			
		} 
	}
}