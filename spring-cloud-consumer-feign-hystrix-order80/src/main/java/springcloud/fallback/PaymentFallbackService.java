package springcloud.fallback;

import org.springframework.stereotype.Service;
import springcloud.service.PaymentService;
@Service
public class PaymentFallbackService implements PaymentService {
    @Override
    public String paymentInfo_OK(Long id) {
        return "--------PaymentFallbackService fall back-paymentInfo_OK,O(T-T)O";
    }
    @Override
    public String paymentInfo_TimeOut(Long id) {
        return "--------PaymentFallbackService fall back-ppaymentInfo_TimeOut,O(T-T)O";
    }
}
