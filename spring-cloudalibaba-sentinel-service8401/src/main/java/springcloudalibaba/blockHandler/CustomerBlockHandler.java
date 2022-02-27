package springcloudalibaba.blockHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import entities.CommonResult;

public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException blockException){
        return new CommonResult(4444,"用户自定义的handlerException---1");
    }
    public static CommonResult handlerException2(BlockException blockException){
        return new CommonResult(4444,"用户自定义的handlerException----2");
    }
}
