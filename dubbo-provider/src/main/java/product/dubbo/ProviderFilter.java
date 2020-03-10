package product.dubbo;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;

public class ProviderFilter implements Filter {
	/**
	 * do invoke filter.
	 * <p>
	 * <code>
	 * // before filter
	 * Result result = invoker.invoke(invocation);
	 * // after filter
	 * return result;
	 * </code>
	 *
	 * @param invoker    service
	 * @param invocation invocation.
	 * @return invoke result.
	 * @throws RpcException
	 * @see Invoker#invoke(Invocation)
	 */
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

		RpcContext.getContext().setAttachment("filter", invocation.getAttachments().get("filter"));
		Result invoke = invoker.invoke(invocation);
		invoke.getAttachments().put("filter", RpcContext.getContext().getAttachment("filter"));
		return invoke;
	}
}
