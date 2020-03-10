package product.dubbo;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.RpcContext;

import product.common.dubbo.DubboService;

@Service("dubboService")
public class DubboServiceProvider implements DubboService {
	@Override
	public String hello(String param) {
		// try {
		// 	Thread.sleep(100000);
		// } catch (InterruptedException e) {
		// 	e.printStackTrace();
		// }
		String filter = RpcContext.getContext().getAttachment("filter");
		RpcContext.getContext().setAttachment("filter", "李政武" + filter);
		return "哈哈哈哈";
	}
}
