package springcloudalibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"springcloudalibaba.dao"})
public class MyBatisConfig {
}
