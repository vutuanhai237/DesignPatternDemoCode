package proxy;

public class Client {
	public static void main(String args[]) {
		Internet intConn = new InternetProxy();
		System.out.println("Connecting to uit.edu.vn ...");
		intConn.connectTo("uit.edu.vn");
		System.out.println("Connecting to adult-site.com ...");
		intConn.connectTo("adult-site.com");

	}
}
