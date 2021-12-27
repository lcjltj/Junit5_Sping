package com.example.junit5_database;

import com.example.junit5_database.common.dto.response.DefaultResponse;
import com.example.junit5_database.common.util.PasswordEncryption;
import com.example.junit5_database.test.dto.request.SignUpRequestDTO;
import com.example.junit5_database.test.entity.UserEntity;
import com.example.junit5_database.test.exception.CustomException;
import com.example.junit5_database.test.repository.UserRepository;
import com.example.junit5_database.test.service.JunSerivce;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class Junit5DatabaseApplicationTests {

    @Mock(lenient = true)
    UserRepository userRepository;

    @Mock(lenient = true)
    PasswordEncryption passwordEncryption;

    @InjectMocks
    JunSerivce junSerivce;

    @Test
    @DisplayName("회원가입 중복 이메일 테스트.")
    public void existEmailTest() {
        // Given
        SignUpRequestDTO signUpRequestDTO =
                new SignUpRequestDTO("lcjltj@gmail.com",
                        "이찬준",
                        "password");

        given(userRepository.existsByEmail(signUpRequestDTO.getEmail()))
                .willReturn(true);

        // When
        CustomException assertThrows = assertThrows(CustomException.class, () -> junSerivce.signUp(signUpRequestDTO));

        // Then
        assertAll(
                () -> assertEquals(100, assertThrows.getErrorCode()),
                () -> assertEquals("사용중인 이메일 입니다.", assertThrows.getMessage())
        );

    }

    @Test
    @DisplayName("회원가입 중복 닉네임 테스트.")
    public void existNicknameTest() {
        // Given
        SignUpRequestDTO signUpRequestDTO =
                new SignUpRequestDTO("lcjltj@gmail.com",
                        "이찬준",
                        "password");

        given(userRepository.existsByEmail(signUpRequestDTO.getEmail()))
                .willReturn(false);

        given(userRepository.existsByNickname(signUpRequestDTO.getName()))
                .willReturn(true);

        // When
        CustomException assertThrows = assertThrows(CustomException.class, () -> junSerivce.signUp(signUpRequestDTO));

        // Then
        assertAll(
                () -> assertEquals(101, assertThrows.getErrorCode()),
                () -> assertEquals("사용중인 닉네임 입니다.", assertThrows.getMessage())
        );
    }

    @Test
    @DisplayName("회원가입 테스트.")
    public void signUpUserTest() {
        // Given
        SignUpRequestDTO signUpRequestDTO =
                new SignUpRequestDTO("lcjltj@gmail.com",
                        "이찬준",
                        "password");

        given(userRepository.existsByEmail(signUpRequestDTO.getEmail()))
                .willReturn(false);

        given(userRepository.existsByNickname(signUpRequestDTO.getName()))
            .willReturn(false);

        given(passwordEncryption.encode(any()))
                .willReturn("encPassword");

        UserEntity userEntity = UserEntity.builder()
                .email(signUpRequestDTO.getEmail())
                .nickname(signUpRequestDTO.getName())
                .password(passwordEncryption.encode(signUpRequestDTO.getPassword()))
                .build();

        given(userRepository.saveUser(any()))
                .willReturn(userEntity);

        // When
        DefaultResponse<UserEntity> response = junSerivce.signUp(signUpRequestDTO);

        // Then
        assertAll(
                () -> assertEquals(userEntity.getEmail(), response.getBody().getEmail()),
                () -> assertEquals(userEntity.getPassword(), response.getBody().getPassword())
        );

    }


}