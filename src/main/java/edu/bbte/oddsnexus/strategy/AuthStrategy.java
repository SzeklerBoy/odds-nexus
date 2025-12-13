package edu.bbte.oddsnexus.strategy;

import edu.bbte.oddsnexus.model.User;

public interface AuthStrategy {
    User register(User user);
    boolean login(User user);

}
