package cn.itcast.test;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;
import java.util.MissingResourceException;

public class TestMybatis {

    @Test
    public void run1() {
        SqlSession sqlSession = null;
        try {
            sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml")).openSession();
            AccountDao mapper = sqlSession.getMapper(AccountDao.class);
            List<Account> accounts = mapper.findAll();
            for (Account account : accounts) {
                System.out.println(account);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void run2() {
        SqlSession sqlSession = null;
        try {
            sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml")).openSession();
            AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
            Account account = new Account();
            account.setName("熊大");
            account.setMoney(400d);
            accountDao.saveAccount(account);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
