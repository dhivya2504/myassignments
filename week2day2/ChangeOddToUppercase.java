package week2day2;

public class ChangeOddToUppercase {

	public static void main(String[] args) {
		String test = "changeme";
		char[] chars = test.toCharArray();

		for (int i = chars.length - 1; i >= 0; i--) {

			if (i % 2 != 0) {

				chars[i] = Character.toUpperCase(chars[i]);
			}
		}

		System.out.println(new String(chars));
	}
}