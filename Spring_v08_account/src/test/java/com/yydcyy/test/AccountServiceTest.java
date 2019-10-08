package com.yydcyy.test;

import com.yydcyy.dao.IAccountDao;
import com.yydcyy.domain.Account;
import com.yydcyy.service.IAccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.util.locale.InternalLocaleBuilder;

import java.util.List;

/**
 * @author YYDCYY
 * @create 2019-09-25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    private IAccountService as;

    @Test
    public void testTransfer(){
        as.transfer("赵薇","羽扬",1000f);
    }
}
