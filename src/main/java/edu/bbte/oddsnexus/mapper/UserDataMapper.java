package edu.bbte.oddsnexus.mapper;

import edu.bbte.oddsnexus.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDataMapper {

    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    List<User> findAll();
    int insert(User user);
    int update(User user);
    int delete(User user);
}
