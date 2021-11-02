package com.neo;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.neo.entity.UserEntity;
import com.neo.exception.DataNotFoundException;
import com.neo.repository.UserRepository;
import com.neo.service.UserService;

@SpringBootTest
public class UpdateUser {

	@Autowired
	private UserService service;
	@Autowired
	private UserRepository repo;
	@Test
	@Rollback(false)
	public void updateUsersTest ()  {
		UserEntity user=new UserEntity();
		user.setId(2);
		user.setFirstName("Rishabh");
		user.setLastName("Mishra");
		user.setEmail("rm705400@gmail.com");
		user.setStatus("NR");
	    user.setBirthday(LocalDate.EPOCH);
		user.setPinCode("230001");
		user.setCreateDate(new Timestamp(new Date().getTime()));
		repo.save(user);
		
		UserEntity userfind=repo.getById(user.getId());
		
		assertThat(userfind.getFirstName()).isEqualTo("Rishabh");
	}
}
