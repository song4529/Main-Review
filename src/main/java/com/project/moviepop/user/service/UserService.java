package com.project.moviepop.user.service;

import com.project.moviepop.exception.BusinessLogicException;
import com.project.moviepop.exception.ExceptionCode;
import com.project.moviepop.user.entity.User;
import com.project.moviepop.user.entity.UserStatus;
import com.project.moviepop.user.repository.UserRepository;
import com.project.moviepop.utils.CustomBeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CustomBeanUtils<User> customBeanUtils;

    //CRUD 메인 메서드
    public User creatUser(User user) {
        User findUser = userRepository.findByEmail(user.getEmail());
        checkEmailExist(findUser);
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        //해당 유저를 찾는다
        User findUser = findUser(user.getUserId());
        //바뀐 내용에 대해서 수정한다
        User updateUser = customBeanUtils.copyNonNullProperties(user, findUser);

        return userRepository.save(updateUser);
    }

    public User updateUserPassword(long userId, String currentPassword, String newPassword) {
        //아이디 번호를 통해 유저를 찾는다
        User findUser = verifyUserId(userId);
        //기존 비밀번호 불일치시 예외 처리
        if(!findUser.getPassword().equals(currentPassword))
            throw new BusinessLogicException(ExceptionCode.PASSWORD_INCORRECT);
        //비밀번호 변경
        findUser.setPassword(newPassword);

        return userRepository.save(findUser);
    }

    public void deleteUser(long userId) {
        User findUser = verifyUserId(userId);
        findUser.setUserStatus(UserStatus.USER_WITHDRAW);
    }

    //기타 사용된 메서드
    @Transactional(readOnly = true)
    public User findUser(long userId) {
        return verifyUserId(userId);
    }

    private User verifyUserId(long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));
    }

    public boolean checkEmailExist(User user) {
        if(userRepository.findByEmail(user.getEmail()) != null) {
            throw new BusinessLogicException(ExceptionCode.USER_EXISTS);
        }
        return true;
    }
}
