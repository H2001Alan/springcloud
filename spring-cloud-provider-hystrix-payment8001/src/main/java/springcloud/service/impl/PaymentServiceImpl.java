package springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import springcloud.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler")
    @Override
    public String paymentInfo_Ok(Long id) {
        return "线程池:"+Thread.currentThread().getName()+"payment_Ok,id:"+id+"\t"+"o(n_n)o哈哈哈哈哈~";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String paymentInfo_TimeOut(Long id) {
        int numTime=5000;
//        int age=10/0;
        try {
            Thread.sleep(numTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:"+Thread.currentThread().getName()+"payment_TimeOut,:"+id+"\t"+"o(n_n)o哈哈哈哈哈~"+"耗时:"+numTime;
    }

    public String paymentInfo_TimeOutHandler(Long id) {
        return "线程池:"+Thread.currentThread().getName()+"payment_TimeOutHandler,id:"+id+"\t"+"我是一个兜底方法";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Long id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(Long id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }
}
