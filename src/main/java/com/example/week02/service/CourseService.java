package com.example.week02.service;

import com.example.week02.domain.Course;
import com.example.week02.domain.CourseRepository;
import com.example.week02.domain.CourseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // lombok 을 통해 아래 생성자 자동 생성
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class CourseService {

    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final CourseRepository courseRepository;

    // 생성자를 통해, Service 클래스를 만들 때 꼭 Repository 를 넣어주도록 스프링에게 알려줌 !

    // public CourseService(CourseRepository courseRepository) {
    //      this.courseRepository = courseRepository;
    // }

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌 (이 어노테이션때문에 자동으로 DB에 반영)
    public Long update(Long id, CourseRequestDto requestDto) {
        Course course1 = courseRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        course1.update(requestDto);
        return course1.getId();
    }
}
