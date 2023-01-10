package com.example.week02.controller;

import com.example.week02.domain.Course;
import com.example.week02.domain.CourseRepository;
import com.example.week02.domain.CourseRequestDto;
import com.example.week02.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class CourseController {

    private final CourseRepository courseRepository;

    private final CourseService courseService;

    // PostMapping 을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    @PostMapping("/api/courses")
    public Course createCourse(@RequestBody CourseRequestDto requestDto) {
        // @RequestBody 라는 어노테이션은 컨트롤러에서 요청을 받는 녀석이라는 걸 표시
        // requestDto 는, 생성 요청을 의미합니다.
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
        // 그 정보를 가져오는 녀석입니다.

        // 저장하는 것은 Dto 가 아니라 Course 이니, Dto 의 정보를 course 에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.
        Course course = new Course(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return courseRepository.save(course);
    }

    @GetMapping("/api/courses")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
}