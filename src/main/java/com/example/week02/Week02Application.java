package com.example.week02;

import com.example.week02.domain.Course;
import com.example.week02.domain.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing // 생성일자, 수정일자 자동 업데이트 && Timestamped 클래스와 연관
@SpringBootApplication
public class Week02Application {

    public static void main(String[] args) {
        SpringApplication.run(Week02Application.class, args);
    }

    // Week02Application.java 의 main 함수 아래에 붙여주세요.
    @Bean
    public CommandLineRunner demo(CourseRepository repository) {
        return (args) -> {
//			Course course1 = new Course("웹개발의 봄 Spring", "홍길동");
//			repository.save(course1);
//			List<Course> courseList = repository.findAll();
//
//			for(int i = 0; i < courseList.size(); i ++) {
            // System.out.println(courseList.get(i)); 주소가 찍힐 것.
//				Course c = courseList.get(i);
//				System.out.println(c.getTitle());
//				System.out.println(c.getTutor());
//			}

            // 데이터 저장하기
            repository.save(new Course("프론트엔드의 꽃, 리액트", "김삿갓"));

            // 데이터 전부 조회하기
            List<Course> courseList = repository.findAll();
            for (int i = 0; i < courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            // 데이터 하나 조회하기
            Course course = repository.findById(1L).orElseThrow(
                    () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
            );
        };
    }
}
