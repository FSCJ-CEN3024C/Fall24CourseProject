package edu.fscj.cen3024c.financialclarity.service;

import edu.fscj.cen3024c.financialclarity.dto.UserDTO;
import edu.fscj.cen3024c.financialclarity.entity.User;

import edu.fscj.cen3024c.financialclarity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository usersRepository;


    public List<User> findAll() { return usersRepository.findAll(); }
    public User save( User user ) { return usersRepository.save(user); }
    public void deleteByUsername(String username) {usersRepository.deleteByUsername(username);}
    public User findByUsername(String username) {return usersRepository.findByUsername(username);}

    public UserDTO save(UserDTO userDTO) {
        // Convert UserDTO to User entit
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        User savedUser = usersRepository.save(user);

        // Return saved User as DTO
        return convertToDTO(savedUser);
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getAge(), user.getTotalIncome(), user.getTotalExpences() );
    }

}
