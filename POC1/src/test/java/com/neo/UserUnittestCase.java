package com.neo;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neo.entity.UserEntity;
import com.neo.repository.UserRepository;

@SpringBootTest
class UserUnittestCase {

	@Autowired
	private UserRepository repo;
	
	
	private String pattern = "dd-MM-yyyy";
	String dateInString =new SimpleDateFormat(pattern).format(new Date());
	@Test
	void isxitsUser() {
		UserEntity user = new UserEntity();
		user.setFirstName("Rishabh");
		user.setLastName("Mishra");
		user.setEmail("rm705400@gmail.com");
		user.setStatus("NR");
	    user.setBirthday(LocalDate.EPOCH);
		user.setPinCode("230001");
		user.setCreateDate(new Timestamp(new Date().getTime()));
		repo.save(user);
		Boolean actualResult=repo.existsById(user.getId());
     assertThat(actualResult).isTrue();
	}

}
