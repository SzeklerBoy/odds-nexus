package edu.bbte.oddsnexus.strategy.dblogin;

import edu.bbte.oddsnexus.model.User;
import edu.bbte.oddsnexus.strategy.AuthStrategy;

public class DbLoginStrategy implements AuthStrategy {
    @Override
    public User register(User user) {
        System.out.println("DB register");
        return null;
    }

    @Override
    public boolean login(User user) {
        System.out.println("DB login");
        return false;
    }
}
