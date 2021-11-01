package com.neo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neo.exception.DataNotFoundException;
import com.neo.repository.UserRepository;
import com.neo.service.UserService;

@SpringBootTest
class DeleteUser {

	@Autowired
	private UserService service;
	@Autowired
	private UserRepository repo;
	@Test
	public void deleteUsersTest () throws DataNotFoundException {
		int userId=1;
		service.deleteuserByid(userId);
		assertThat(repo.existsById(userId)).isFalse();
	}
	@Test
	public void deleteUsersTest1 () throws DataNotFoundException {
		int userId=1;
		service.deleteuserByid(userId);
		assertThat(repo.existsById(userId)).isFalse();
	}
}
