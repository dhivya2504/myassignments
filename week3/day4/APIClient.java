package week3.day4;

public class APIClient {
	public void sendRequest(String endpoint) {
		System.out.println("This is the endpoint");
		System.out.println(endpoint);
	}

	public void sendRequest(String endpoint, String requestBody, boolean requestStatus) {
		System.out.println("This is endpoint with request body");
		System.out.println(endpoint + requestBody + requestStatus);
		if (requestStatus) {
			System.out.println("The request is sent");
		}

		else {
			System.out.println("The request is not sent");
		}
	}

	public static void main(String args[]) {

		APIClient api = new APIClient();
		api.sendRequest("post", "This is a message", false);
		api.sendRequest("post");
	}
}
