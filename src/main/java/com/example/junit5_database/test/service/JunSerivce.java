package com.example.junit5_database.test.service;

import com.example.junit5_database.common.dto.response.DefaultResponse;
import com.example.junit5_database.common.util.PasswordEncryption;
import com.example.junit5_database.test.dto.request.SignUpRequestDTO;
import com.example.junit5_database.test.entity.UserEntity;
import com.example.junit5_database.test.exception.CustomException;
import com.example.junit5_database.test.exception.DefaultExceptionType;
import com.example.junit5_database.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JunSerivce {

    private final UserRepository userRepository;
    private final PasswordEncryption passwordEncryption;

    public DefaultResponse<UserEntity> signUp(final SignUpRequestDTO requestDTO) throws CustomException {
        existEmailThrows(requestDTO.getEmail());
        existNicknameThrows(requestDTO.getName());
        UserEntity userEntity = registerUser(requestDTO);

        return new DefaultResponse<>(userEntity);
    }

    private void existEmailThrows(final String email) {
        if (userRepository.existsByEmail(email)) {
            throw new CustomException(DefaultExceptionType.USED_EMAIL);
        }
    }

    private void existNicknameThrows(final String nickname){
        if (userRepository.existsByNickname(nickname)) {
            throw new CustomException(DefaultExceptionType.USED_NICKNAME);
        }
    }

    private UserEntity registerUser(final SignUpRequestDTO requestDTO) {
        String encPassword = passwordEncryption.encode(requestDTO.getPassword());

        UserEntity user = UserEntity.builder()
                .email(requestDTO.getEmail())
                .nickname(requestDTO.getName())
                .password(encPassword)
                .build();

        return userRepository.saveUser(user);
    }

}
