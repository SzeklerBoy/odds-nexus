package edu.bbte.oddsnexus.strategy.oauthlogin;

import edu.bbte.oddsnexus.model.User;
import edu.bbte.oddsnexus.strategy.AuthStrategy;

public class OAuthLoginStrategy implements AuthStrategy {
    @Override
    public User register(User user) {
        System.out.println("Oauth register");
        return null;
    }

    @Override
    public boolean login(User user) {
        System.out.println("Oauth login");
        return false;
    }
}
