package edu.bbte.oddsnexus;

import edu.bbte.oddsnexus.model.User;
import edu.bbte.oddsnexus.strategy.LoginContext;
import edu.bbte.oddsnexus.strategy.dblogin.DbLoginStrategy;
import edu.bbte.oddsnexus.strategy.oauthlogin.OAuthLoginStrategy;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, Gradle!");

        User user = new User("Kicsi", "bela123");

        LoginContext loginContext = new LoginContext(new DbLoginStrategy());

        if(loginContext.performLogin(user)) {
            System.out.println("Logged in successfully");
        } else {
            System.out.println("Log in failed");
        }

  }
}
