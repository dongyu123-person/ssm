package cn.itcast.dao;

import cn.itcast.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {

    //查询所有
    List<Account> findAll();

    //保存账户信息
    void saveAccount(Account account);

}