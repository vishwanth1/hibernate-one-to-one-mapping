package com.vishwa.Hibernate.Mappings;

import com.vishwa.Hibernate.Mappings.dao.AppDao;
import com.vishwa.Hibernate.Mappings.entity.Instructor;
import com.vishwa.Hibernate.Mappings.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateMappingsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
			createInstructor(appDao);
			findInstructor(appDao);
			deleteInstructor(appDao);
		};
	}

	private void deleteInstructor(AppDao appDao) {
		appDao.deleteInstructorById(2);
		System.out.println("Deleted Successfully");
	}

	private void findInstructor(AppDao appDao) {
		Instructor instructor =  appDao.findInstructorById(1);
		System.out.println(instructor);
		System.out.println(instructor.getInstructorDetail());
	}

	private void createInstructor(AppDao appDao) {
		Instructor instructor = new Instructor("Rahul", "G", "sample1@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("sample1.com", "Business");

		instructor.setInstructorDetail(instructorDetail);

		appDao.save(instructor);
	}

}
