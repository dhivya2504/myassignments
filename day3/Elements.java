package week3.day3;

public class Elements extends Button {

	public static void main(String[] args) {

		Elements elem = new Elements();
		elem.click();
		elem.setText("madurai");
		elem.submit();
		CheckBoxButton butt = new CheckBoxButton();
		butt.clickCheckButton();
		RadioButton rad = new RadioButton();
		rad.selectRadioButton();
		TextField tex = new TextField();
		tex.getText("chennai");
	}
}
