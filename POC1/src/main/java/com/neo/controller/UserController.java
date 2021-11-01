/**
 * 
 */
package com.neo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neo.dto.UserDTO;
import com.neo.entity.UserEntity;
import com.neo.enumm.DOBEnum;
import com.neo.enumm.DeleteEnum;
import com.neo.enumm.JoiningDateEnum;
import com.neo.enumm.StandardDateParser;
import com.neo.exception.DataNotFoundException;
import com.neo.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rishabh Mishra
 *
 */
@RestController
@RequestMapping("/api/onboarding")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;
	/*
	 * create user
	 * 
	 */

	@PostMapping("/save")
	public UserEntity createUser(@RequestBody UserDTO user) {
		return userService.save(user);
	}

	/*
	 * view user +filter User
	 * 
	 */
	
	
	// 5.Update record in DB
		@PutMapping("/update")
		public ResponseEntity<String> update(@RequestBody UserEntity User)throws DataNotFoundException {
			ResponseEntity<String> resp = null;
			if (User.getId() == null || !userService.isUserExist(User.getId())) {
				resp = new ResponseEntity<String>("RECORD NOT EXIST IN DB", HttpStatus.BAD_REQUEST);
			} else {
				userService.updateUser(User) ;
				resp = new ResponseEntity<String>("User WITH '" + User.getId() + "' UPDATED", HttpStatus.OK);
			}
			return resp;
		}

	/*
	 * view user +filter User
	 * 
	 */
	@GetMapping("/all")
	public ResponseEntity<List<UserEntity>> getAll(@RequestParam(defaultValue = "", required = false) String firstName,
			@RequestParam(defaultValue = "", required = false) String lastName,
			@RequestParam(defaultValue = "", required = false) String pincode,
			DOBEnum dobsorting,JoiningDateEnum joindatesorting
			) {

		List<UserEntity> list = null;

		boolean flag = (firstName.isEmpty() && lastName.isEmpty() && pincode.isEmpty());
		if (flag == false) {
			list = userService.getAlluserDetailsBasedOnValue(firstName, lastName, pincode);
		} else {
			list = userService.getAlluserDetails(dobsorting,joindatesorting);
		}
		return new ResponseEntity<List<UserEntity>>(list, HttpStatus.OK);
	}

	/*
	 * Delete User Soft+hard
	 * 
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id, DeleteEnum type) {

		ResponseEntity<String> resp = null;
		if (userService.isuserExist(id)) {
			try {
				String deletType = type.toString();
				if (deletType.equals("hard")) {
					userService.deleteuserByid(id);
					log.info("if is exicuted");
				} else {
					log.info("else is exicuted");
					userService.updateRecords(id);
				}
				resp = new ResponseEntity<String>("RECORD HAS BEEN DELETED WITH " + id, HttpStatus.OK);
			} catch (Exception e) {
				resp = new ResponseEntity<String>("RECORD CAN'T BE DELETED, IT USED ANOTHER OPERATIONS " + id,
						HttpStatus.BAD_REQUEST);
			}
		} else {
			resp = new ResponseEntity<String>("RECORD WITH " + id + " NOT FOUND", HttpStatus.NOT_FOUND);
		}
		return resp;
	}

}
