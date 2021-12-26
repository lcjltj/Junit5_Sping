package com.example.junit5_database.test.service;

import com.example.junit5_database.common.dto.response.DefaultResponse;
import com.example.junit5_database.test.dto.request.SignUpRequestDTO;
import com.example.junit5_database.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JunSerivce {

    private final UserRepository userRepository;

    public DefaultResponse<Boolean> signUp(SignUpRequestDTO requestDTO) {
        ifEnabledMailOrThrow(requestDTO.getEmail());

        return new DefaultResponse<>(true);
    }

    private void ifEnabledMailOrThrow (String email) {
        boolean existsByEmail = userRepository.existsByEmail(email);
        if (existsByEmail) {
            throw new NullPointerException();
        }
    }
}
