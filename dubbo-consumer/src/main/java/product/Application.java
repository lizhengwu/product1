package product;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import product.common.dubbo.DubboService;

public class Application {

	public static void main(String[] args) throws IOException {
		System.setProperty("java.net.preferIPv4Stack", "true");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"consumer.xml"});

		context.start();
		DubboService dubboService = (DubboService) context.getBean("dubboService");
		dubboService.hello("lizhengwu");
		System.out.println("consumer started.");
		System.in.read(); // press any key to exit
	}
}
