package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/testFindAll")
    public String findAll(Model model) {
        System.out.println("表现层：查询所有的账户。。。");
        List<Account> list = accountService.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping("/save")
    public String save(Account account, HttpServletRequest request, HttpServletResponse response) {
        accountService.saveAccount(account);
        return "forward:/account/testFindAll";

//        try {
//            request.getRequestDispatcher("1231").forward(request,response);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "list";
    }


}
