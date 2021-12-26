package com.example.junit5_database.test.controller;


import com.example.junit5_database.test.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Mock
    UserRepository userRepository;

    @Test
    @DisplayName("이메일 존재 여부 테스트")
    void emailTest(){

        String email = "test@email.com";
        String email2 = "test@email.com";


        given(userRepository.existsByEmail(email)).willThrow(new NullPointerException());

        given(userRepository.existsByEmail(email2)).willThrow(new SQLException());

        assertEquals(true,userRepository.existsByEmail(email) , () -> "성공");

        assertThrows(SQLException.class,
                () -> userRepository.existsByEmail(email2),
                "SQL 정상"
                );



    }
    @Test
    @DisplayName("닉네임 존재 여부 테스트")
    public void nickNameTest(){

        String nickName = "yb";

        given(userRepository.existsByNickname(nickName)).willReturn(true);

        assertEquals(true,userRepository.existsByNickname(nickName) , () -> "성공");

    }

    @Test
    @DisplayName("회원가입 테스트")
    public void userSaveTest() {


    }
}