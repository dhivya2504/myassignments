package week4.day1;

public class JavaConnection implements DatabseConnection {
	@Override
	public void connect() {
		System.out.println("Inside connect");
	}

	@Override
	public void disconnect() {
	System.out.println("Inside disconnect");
		
	}

	@Override
	public void executeUpdate() {
		System.out.println("Inside execute update");
		
	}
	

	public static void main(String[] args) {
		JavaConnection jav = new JavaConnection();
		jav.connect();
		jav.disconnect();
		jav.executeUpdate();
		
	}

}
