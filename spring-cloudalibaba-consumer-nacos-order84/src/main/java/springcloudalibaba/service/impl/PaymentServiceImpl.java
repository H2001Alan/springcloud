package springcloudalibaba.service.impl;

import entities.CommonResult;
import entities.Payment;
import org.springframework.stereotype.Component;
import springcloudalibaba.service.PaymentService;
@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回");
    }
}
