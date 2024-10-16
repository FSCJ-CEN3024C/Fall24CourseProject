package edu.fscj.cen3024c.financialclarity.service;

import edu.fscj.cen3024c.financialclarity.dto.UserDTO;
import edu.fscj.cen3024c.financialclarity.entity.User;

import edu.fscj.cen3024c.financialclarity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository usersRepository;

    public List<User> findAll() { return usersRepository.findAll(); }
    public User findByUsername(String username) {return usersRepository.findByUsername(username);}

    @Transactional
    public void deleteByUsername(String username) {usersRepository.deleteByUsername(username);}

    public User save( User user ) { return usersRepository.save(user); }
    public UserDTO save(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setAge(userDTO.getAge());
        user.setTotalExpences(userDTO.getTotalExpense());
        user.setTotalIncome(userDTO.getTotalIncome());
        User savedUser = usersRepository.save(user);
        return convertToDTO(savedUser);
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getAge(), user.getTotalIncome(), user.getTotalExpences() );
    }
}
