package edu.bbte.oddsnexus.strategy.dblogin;

import edu.bbte.oddsnexus.mapper.UserDataMapper;
import edu.bbte.oddsnexus.mapper.db.UserDataMapperDbImpl;
import edu.bbte.oddsnexus.model.User;
import edu.bbte.oddsnexus.security.PasswordHasher;
import edu.bbte.oddsnexus.strategy.AuthStrategy;

public class DbLoginStrategy implements AuthStrategy {

    final UserDataMapper mapper = new UserDataMapperDbImpl();
    private final PasswordHasher passwordHasher = new PasswordHasher();

    @Override
    public User register(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        if (user.getUsername() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("Username and password must not be null");
        }

        String hashedPassword = passwordHasher.hash(user.getPassword());
        user.setPassword(hashedPassword);

        mapper.insert(user);
        return user;
    }

    @Override
    public boolean login(User user) {
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            return false;
        }

        return mapper.findByUsername(user.getUsername())
                .map(storedUser -> passwordHasher.matches(user.getPassword(), storedUser.getPassword()))
                .orElse(false);
    }
}
