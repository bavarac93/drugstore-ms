package com.example.dms.service.impl;

import com.example.dms.dao.RoleRepository;
import com.example.dms.dao.UserRepository;
import com.example.dms.security.Role;
import com.example.dms.security.User;
import com.example.dms.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(final UserRepository userRepository, final RoleRepository roleRepository) {
        this.userRepository = Objects.requireNonNull(userRepository, "userRepository cannot be null");
        this.roleRepository = Objects.requireNonNull(roleRepository, "roleRepository cannot be null");
    }

    @Override
    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    @Override
    public void addRoleToUser(final String username, final String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(final String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
