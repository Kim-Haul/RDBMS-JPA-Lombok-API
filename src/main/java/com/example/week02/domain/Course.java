package com.example.week02.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Course {

    // JPA 는 SQL 을 쓰지 않고 데이터를 생성, 조회, 수정, 삭제할 수 있도록 해주는 번역기
    // Spring 에서 Domain 이 RDBMS 의 Table 과 1:1 대응, Repository 가 SQL 의 역할. (해당 영역의 코드가 JPA 코드를 사용하는 것과 똑같음)
    // 테이블은 Domain, SQL 은 Repository 다!

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String title;

    @Column(nullable = false)
    private String tutor;

    public String getTitle() {
        return this.title;
    }

    public String getTutor() {
        return this.tutor;
    }

    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }
}