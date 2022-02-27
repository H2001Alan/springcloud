package springcloudalibaba.service.impl;

import org.springframework.stereotype.Service;
import springcloudalibaba.dao.AccountDao;
import springcloudalibaba.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;
    @Override
    public void decrease(Long userId, BigDecimal money) {
        accountDao.decrease(userId,money);
    }
}
