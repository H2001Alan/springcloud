package springcloudalibaba.service;

import entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "seata-account-service")
public interface AccountService {
    @PostMapping(value = "/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long id,
                                 @RequestParam("money") BigDecimal money);
}
