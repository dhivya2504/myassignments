package week2.day1;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int input=12345;
int reverse=0;
for (; input != 0; input /= 10) {
    int digit = input % 10;
    reverse = reverse * 10 + digit;
}
System.out.println("Reversed Number: " + reverse);
	}

}
