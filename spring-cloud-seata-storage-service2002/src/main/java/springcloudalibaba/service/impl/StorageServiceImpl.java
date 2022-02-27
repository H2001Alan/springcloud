package springcloudalibaba.service.impl;

import org.springframework.stereotype.Service;
import springcloudalibaba.dao.StorageDao;
import springcloudalibaba.service.StorageService;

import javax.annotation.Resource;

@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;
    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId,count);
    }
}
