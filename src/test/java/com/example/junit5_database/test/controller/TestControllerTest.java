//package com.example.junit5_database.test.controller;
//
//import com.example.junit5_database.test.agreegator.SignUpAggregator;
//import com.example.junit5_database.test.dto.request.SignUpRequestDTO;
//import com.example.junit5_database.test.entity.TestEntity;
//import com.example.junit5_database.test.repository.TestRepository;
//import com.example.junit5_database.test.service.TestService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.aggregator.AggregateWith;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.BDDMockito.given;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@AutoConfigureMockMvc
//class TestControllerTest {
//
//    @Mock
//    TestRepository testRepository;
//
//    @Autowired
//    TestService testService;
//
//    @ParameterizedTest
//    @DisplayName("Mock 사용중인 이름 검색")
//    @ValueSource(strings = {"이찬준"})
//    void name_check_used_mock(String name) {
//        // Given
//        given(testRepository.findByName(name))
//                .willReturn(new TestEntity(1L, "이찬준"));
//        // When
//        TestEntity byName = testRepository.findByName(name);
//        // Then
//        assertEquals(name, byName.getName(),
//                () -> "동일한 이름이 존재 합니다.");
//    }
//
//    @ParameterizedTest
//    @DisplayName("Mock 사용중인 이름 검색_2")
//    @CsvSource({"이찬준"})
//    void test(SignUpRequestDTO requestDTO) {
//        // Given
//        given(testRepository.findByName(requestDTO.getName()))
//                .willReturn(new TestEntity(1L, "이찬준"));
//        // When
//        TestEntity byName = testRepository.findByName(requestDTO.getName());
//        System.out.println(byName);
//        System.out.println(byName.getName());
//        // Then
//        assertEquals(requestDTO.getName(), byName.getName(),
//                () -> "동일한 이름이 존재 합니다.");
//    }
//
//    @Test
//    void dtd() {
//        given(testRepository.findByName("이찬준"))
//                .willReturn(new TestEntity(5L, "이찬준"));
//
//        TestEntity enabledName = testService.isEnabledName("이찬준");
//
//    }
//
//}