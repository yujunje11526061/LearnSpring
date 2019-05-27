package com.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.dao2.OrderItemMapper2;
import com.mmall.pojo.OrderItem;
import com.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "iOrderItemServiceImpl2")
public class OrderItemServiceImpl2 implements IOrderItemService {

    @Autowired
    private OrderItemMapper2 orderItemMapper2;

    @Override
    public OrderItem getOrderItemByID(Integer id) {
        return orderItemMapper2.selectByPrimaryKey(id);
    }

    @Override
    public List<OrderItem> getOrderItemList(Integer pageNum, Integer pageSize) {

        // 设置分页
        PageHelper.startPage(pageNum, pageSize);
        //紧跟着的第一个select方法会被分页（一次性消费）,【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        //由输出的SQL语句可知，是在原语句后面加了LIMIT
        List<OrderItem> list = orderItemMapper2.selectList();

        //分页时，实际返回的结果list类型是Page<E> extends ArrayList<E>。
        // 如果想获取更多分页信息，需要强制转换为Page<E>，或用PageInfo对结果进行包装，PageInfo包含了非常全面的分页属性
        PageInfo<OrderItem> pageInfo = new PageInfo<>(list);
//        return pageInfo.getList();

        return list;
    }
}
