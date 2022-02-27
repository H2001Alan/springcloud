package springcloud.service;

import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    public String paymentInfo_Ok(Long id);
    public String paymentInfo_TimeOut(Long id);
    public String paymentCircuitBreaker(Long id);
}
