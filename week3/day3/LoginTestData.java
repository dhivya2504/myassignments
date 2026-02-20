package week3.day3;

public class LoginTestData extends TestData{
	public void  enterUsername() {
		System.out.println("the user name is Dhivya");
	}
	public void  enterPassword() {
		System.out.println("the password is 4563");
	}
	public static void main(String[] args) {
		LoginTestData ltd=new LoginTestData();
		ltd.enterCredentials();
		ltd.navigateToHomePage();
		ltd.enterUsername();
		ltd.enterPassword();
		
	}

}
