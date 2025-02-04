package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(UserDto user) {
        user.setAvailableCredit(user.getCreditLimit());
        User temp = new User();
        temp.setAvailableCredit(user.getAvailableCredit());
        temp.setCreditLimit(user.getCreditLimit());
        temp.setEmail(user.getEmail());
        temp.setName(user.getName());
        temp.setPhone(user.getPhone());
        return userRepository.save(temp);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
//		return null;
	}
}

