package main.dao;

import main.entity.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    public void addAccount(Account account,boolean VIP)
    {
        System.out.println(getClass()+" ADDING ACCOUNT");
    }
    public List<Account>findAccounts() throws Exception {
        ArrayList<Account>list=new ArrayList<>();
        list.add(new Account("Palfi","Robert"));
        list.add(new Account("Muratura","Gia"));
        return list;
    }
}
