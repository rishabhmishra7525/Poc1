package com.neo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neo.entity.UserEntity;
import com.neo.repository.UserRepository;
import com.neo.service.UserService;

@SpringBootTest
public class GetAllUser {

	@Autowired
	private UserService service;
	@Autowired
	private UserRepository repo;
	
	@Test
	public void TestListOfUser() {
	List<UserEntity> list=(List<UserEntity>)repo.findAll();
	assertThat(list).size().isGreaterThan(0);
	}
}
