package com.example.junit5_database.test.service;


import com.example.junit5_database.test.dto.request.SignUpRequestDTO;
import com.example.junit5_database.test.dto.response.DefaultResponseDTO;
import com.example.junit5_database.test.entity.UserEntity;
import com.example.junit5_database.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YbService {

    private UserRepository userRepository;

    public DefaultResponseDTO<Boolean> saveUser(SignUpRequestDTO signUpDTO) throws NullPointerException {
        existsByEmail(signUpDTO.getEmail());
        existsByNickname(signUpDTO.getName());
        save(signUpDTO);

        return new DefaultResponseDTO<>(true);
    }

    public void save(SignUpRequestDTO requestDTO) {
        UserEntity userEntity = UserEntity.builder()
                .build();

        userRepository.save(userEntity);
    }

    public void existsByEmail(String email) throws NullPointerException {
        boolean existsByEmail = userRepository.existsByEmail(email);

        if (existsByEmail) {
            throw new NullPointerException();
        }
    }

    public void existsByNickname(String nickname) {

    }
}
