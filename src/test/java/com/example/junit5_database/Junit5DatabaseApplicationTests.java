package com.example.junit5_database;

import com.example.junit5_database.test.dto.request.SignUpRequestDTO;
import com.example.junit5_database.test.repository.UserRepository;
import com.example.junit5_database.test.service.JunSerivce;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class Junit5DatabaseApplicationTests {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    JunSerivce junSerivce;

    @Test
    @DisplayName("존재하는 Email Exception 테스트")
    public void checkExistedEmail() {
        // Given
        String email = "lcjltj@gmail.com";
        given(userRepository.existsByEmail(email))
                .willThrow(new RuntimeException());

        // Then
        assertThrows(RuntimeException.class,
                () -> userRepository.existsByEmail(email),
                () -> "존재 유무 확인 email");
    }

    @Test
    @DisplayName("사용가능한 Email 쿼리 테스트")
    public void checkExistedEmail_2() {
        // Given
        String email = "lcjltj@gmail.com";
        given(userRepository.existsByEmail(email))
                .willReturn(true);

        // When
        boolean isUsedEmail = userRepository.existsByEmail(email);

        // Then
        assertTrue(isUsedEmail, () -> "사용 불가능한 email");
    }

    @Test
    @DisplayName("회원가입 중복 이메일 로직 테스트.")
    public void existEmail() {
        // Given
        SignUpRequestDTO signUpRequestDTO =
                new SignUpRequestDTO("lcjltj@gmail.com",
                        "이찬준",
                        "password");

        given(userRepository.existsByEmail(signUpRequestDTO.getEmail()))
                .willReturn(false);

        // Then
        assertThrows(NullPointerException.class,
                () -> junSerivce.signUp(signUpRequestDTO),
                () -> "오류가 발생하지않아야함.");
    }

}