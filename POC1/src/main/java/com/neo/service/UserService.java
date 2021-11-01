package com.neo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.neo.dto.UserDTO;
import com.neo.entity.UserEntity;
import com.neo.enumm.DOBEnum;
import com.neo.enumm.JoiningDateEnum;
import com.neo.exception.DataNotFoundException;

/**
 * @author Rishabh Mishra
 *
 */
@Service
public interface UserService  {

	UserEntity save(UserDTO user);

	List<UserEntity> getAlluserDetails( DOBEnum dobsorting, JoiningDateEnum joindatesorting);

	List<UserEntity> getAlluserDetailsBasedOnValue(String firstName, String lastName, String pincode);

	boolean isuserExist(Integer id);

	void deleteuserByid(Integer id)  throws DataNotFoundException;

	void updateRecords(Integer id);

	boolean isUserExist(Integer id);

	void updateUser(UserEntity user)throws DataNotFoundException;


	
	

}
