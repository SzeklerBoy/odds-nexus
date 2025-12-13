package edu.bbte.oddsnexus.strategy;

import edu.bbte.oddsnexus.model.User;

public class LoginContext {
    private AuthStrategy authStrategy;

    public LoginContext(AuthStrategy authStrategy) {
        this.authStrategy = authStrategy;
    }

    public void setAuthStrategy(AuthStrategy authStrategy) {
        this.authStrategy = authStrategy;
    }

    public boolean performLogin(User user) {
        return authStrategy.login(user);
    }

    public User performRegister(User user){
        return authStrategy.register(user);
    }
}
