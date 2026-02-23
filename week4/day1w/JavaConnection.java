package week4.day1w;

public class JavaConnection extends MySqlConnection {

	@Override
	public void connect() {
		System.out.println("connect in javaconnection");
		
	}
	@Override
	public void disconnect() {
		System.out.println("disconnect in javaconnection");
		
	}
	@Override
	public void executeUpdate() {
		System.out.println("executeupdate in javaconnection");
		
	}
@Override
void executeQuery() {
	System.out.println("executequery in javaconnection");
	
}
public static void main(String[] args) {
	JavaConnection jav=new JavaConnection();
	jav.connect();
	jav.disconnect();
	jav.executeUpdate();
	jav.executeQuery();
}
}
