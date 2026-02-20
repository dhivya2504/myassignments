package week2day2;
import java.util.Arrays;
public class AnagramChecker {
	public static void main(String[] args) {
        
        String text1 = "stops";
        String text2 = "potss";
        String s1 = text1.toLowerCase();
        String s2 = text2.toLowerCase();

        if (s1.length() != s2.length()) {
            System.out.println("Lengths mismatch,the strings are not an Anagram");
            
        }

    
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        
        boolean result = Arrays.equals(charArray1, charArray2);

       
        if (result) {
            System.out.println("The given strings are Anagram.");
        } else {
            System.out.println("The given strings are not an Anagram.");
        }
    }
}