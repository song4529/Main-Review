package com.project.moviepop.user.service;

import com.project.moviepop.exception.BusinessLogicException;
import com.project.moviepop.exception.ExceptionCode;
import com.project.moviepop.user.entity.User;
import com.project.moviepop.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User creatUser(User user) {
        User findUser = userRepository.findByEmail(user.getEmail());
        checkEmailExist(findUser);
        return userRepository.save(user);
    }

    public boolean checkEmailExist(User user) {
        if(userRepository.findByEmail(user.getEmail()) != null) {
            throw new BusinessLogicException(ExceptionCode.USER_EXISTS);
        }
        return true;
    }
}
