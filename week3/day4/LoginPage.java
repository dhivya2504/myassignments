package week3.day4;

public class LoginPage extends BasePage {
	public void performCommonTasks() {
		super.performCommonTasks();
		System.out.println("This is child performCommonTasks");
	}

	public static void main(String[] args) {
		LoginPage log = new LoginPage();
		log.performCommonTasks();
		BasePage base=new BasePage();
		base.findElement();
		base.enterText();
		base.clickElement();
	}

}
