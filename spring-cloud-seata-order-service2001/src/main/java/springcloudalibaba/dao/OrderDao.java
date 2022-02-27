package springcloudalibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import springcloudalibaba.pojo.Order;

@Mapper
public interface OrderDao {
    //1.新建订单
    public void create(Order order);
    //2.修改订单状态
    public void update(@Param("userId") Long id,
                       @Param("status") Integer status);
}