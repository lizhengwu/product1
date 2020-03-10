package product.dubbo;

import org.springframework.stereotype.Service;

import product.common.dubbo.DubboService;

@Service("dubboServiceStub")
public class DubboServiceStub implements DubboService {


	private final   DubboService dubboService;

	public DubboServiceStub(DubboService dubboService) {
		this.dubboService = dubboService;
	}

	@Override
	public String hello(String param) {
		System.out.println(param);
		String hello = dubboService.hello(param + "stub");
		return hello;
	}
}
