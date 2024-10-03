package edu.fscj.cen3024c.financialclarity.service;

import edu.fscj.cen3024c.financialclarity.entity.User;

import edu.fscj.cen3024c.financialclarity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    @Autowired
    private UserRepository usersRepository;

    public User findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

}
