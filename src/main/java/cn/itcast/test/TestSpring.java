package cn.itcast.test;

import cn.itcast.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void test() {
        ApplicationContext as = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountServiceImpl accountService = as.getBean("accountService", AccountServiceImpl.class);
        accountService.findAll();
        System.out.println(accountService);
    }
}
