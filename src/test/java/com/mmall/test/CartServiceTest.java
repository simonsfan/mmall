package com.mmall.test;

import com.mmall.dao.CartMapper;
import com.mmall.pojo.Cart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.core.InteractionCallback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
//@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
@Transactional
public class CartServiceTest {

    @Autowired
    private CartMapper cartMapper;

    @Test
    public void testCartService(){
        Cart cart = cartMapper.selectByPrimaryKey(126);
        System.out.println(cart.getProductId());
    }
    @Test
    public void addCard(){
        Cart cart1 = new Cart();
        cart1.setUserId(123);
        cart1.setProductId(345);
        cart1.setQuantity(123);
        cart1.setChecked(1);
        cart1.setCreateTime(new Date());
        cart1.setUpdateTime(new Date());
        Cart cart2 = new Cart();
        cart2.setUserId(123);
        cart2.setProductId(345);
        cart2.setQuantity(123);
        cart2.setChecked(1);
        cart2.setCreateTime(new Date());
        cart2.setUpdateTime(new Date());

        cartMapper.insert(cart1);

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i+3));
        }

        cartMapper.insert(cart2);
    }


}
