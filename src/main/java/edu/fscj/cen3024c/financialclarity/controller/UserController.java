package edu.fscj.cen3024c.financialclarity.controller;


import edu.fscj.cen3024c.financialclarity.entity.User;
import edu.fscj.cen3024c.financialclarity.dto.UserDTO;
import edu.fscj.cen3024c.financialclarity.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Convert User entity to UserDTO
    private UserDTO convertToDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getAge(), user.getTotalIncome(), user.getTotalExpences() );
    }


    // Getting all users
    @GetMapping
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.findAll();
        return users.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Getting Users by username
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        return ResponseEntity.ok(user);
    }

    // Creating user
    @PostMapping()
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUser = userService.save(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);

    }

    // Updating user
    @PutMapping("{username}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String username, @RequestBody UserDTO userDTO) {
        User existingUser = userService.findByUsername(username);

        if  (existingUser != null) {
            //User user = existingUser.get();
            User user = existingUser;
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user.setEmail(userDTO.getEmail());
            user.setAge(userDTO.getAge());
            user.setTotalIncome(userDTO.getTotalIncome());
            user.setTotalExpences(userDTO.getTotalExpense());
            User updatedUser = userService.save(user);
            return new ResponseEntity<>(convertToDTO(updatedUser), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    // Deleting user by username
    @DeleteMapping("{username}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable String username) {
        userService.deleteByUsername(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
