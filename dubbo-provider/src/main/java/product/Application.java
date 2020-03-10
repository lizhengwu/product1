package product;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws IOException {
		args= new String[]{"-Djava.net.preferIPv4Stack=true"};


		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"provider.xml"});

		context.start();
		System.out.println("provider started.");
		System.in.read(); // press any key to exit
	}
}
