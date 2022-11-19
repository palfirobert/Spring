package main;

import main.config.DemoConfig;
import main.dao.AccountDAO;
import main.dao.MembershipDAO;
import main.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
        MembershipDAO membershipDAO=context.getBean("membershipDAO", MembershipDAO.class);
        accountDAO.addAccount(new Account(),true);
        accountDAO.findAccounts();
        membershipDAO.addAccount();
        context.close();
    }
}
