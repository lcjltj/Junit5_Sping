package com.example.junit5_database.test.service;

import com.example.junit5_database.common.dto.response.DefaultResponse;
import com.example.junit5_database.test.dto.request.SignUpRequestDTO;
import com.example.junit5_database.test.entity.TestEntity;
import com.example.junit5_database.test.repository.TestRepository;
import com.example.junit5_database.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;
    private final UserRepository userRepository;

    public DefaultResponse<Boolean> signUp(final SignUpRequestDTO requestDTO) {
//        boolean isEnabledName = isEnabledName(requestDTO.getName());
//
//        if (isEnabledName) {
//            TestEntity test = TestEntity.builder()
//                    .name(requestDTO.getName())
//                    .build();
//
//            TestEntity saveId = testRepository.save(test);
//            return new DefaultResponse<>(true);
//
//        } else {
//            return new DefaultResponse<>(100,"존재하는 ID");
//        }
        return null;

    }

    public TestEntity isEnabledName(final String name) {
        return testRepository.findByName(name);
    }
}
