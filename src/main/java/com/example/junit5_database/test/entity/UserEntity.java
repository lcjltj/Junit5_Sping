package com.example.junit5_database.test.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 200, nullable = false)
    private String password;

    @Column(length = 20, nullable = false, unique = true)
    private String nickname;

    @Column(length = 1)
    private String useYn;

    @Column(length = 50)
    private String createUserId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(length = 50)
    private String changeUserId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date changeDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;

}
