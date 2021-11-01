/**
 * 
 */
package com.neo.serviceImp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.dto.UserDTO;
import com.neo.entity.UserEntity;
import com.neo.enumm.DOBEnum;
import com.neo.enumm.JoiningDateEnum;
import com.neo.exception.DataNotFoundException;
import com.neo.repository.UserRepository;
import com.neo.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rishabh Mishra
 *
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserEntity save(UserDTO userdto) {
		UserEntity user = new UserEntity();
		user.setFirstName(userdto.getFirstName());
		user.setLastName(userdto.getLastName());
		user.setEmail(userdto.getEmail());
		user.setStatus("NR");
		user.setBirthday(userdto.getBirthday());
		user.setPinCode(userdto.getPinCode());
		user.setCreateDate(new Timestamp(new Date().getTime()));
		try {
			repo.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<UserEntity> getAlluserDetails(DOBEnum dobsorting, JoiningDateEnum joindatesorting) {

		List<UserEntity> userList = new ArrayList<>();

		if (dobsorting == null && joindatesorting == null) {
			userList = repo.findAll();
			userList = userList.stream().filter(u -> u.getStatus().equals("NR")).collect(Collectors.toList());
		}

		else {

			if (!(joindatesorting == null)) {

				String joiningdate = joindatesorting.toString();
				if (joiningdate.equals("Asc")) {
					userList = repo.findAllSortingOrderASC();
				} else {
					userList = repo.findAllSortingOrderDSC();

				}
			} else {

				String dob = dobsorting.toString();

				if (dob.equals("Asc")) {
					userList = repo.findAlldobOrderASC();
				} else {
					userList = repo.findAllfindAlldobOrderOrderDSC();

				}

			}
		}

		return userList;

	}

	@Override
	public List<UserEntity> getAlluserDetailsBasedOnValue(String firstName, String lastName, String pincode) {

		return repo.findByRecords(firstName, lastName, pincode);
	}

	@Override
	@Transactional
	public boolean isuserExist(Integer id) {
		boolean exist = repo.existsById(id);
		return exist;
	}

	@Override
	@Transactional
	public void deleteuserByid(Integer id) throws DataNotFoundException {
		Optional<UserEntity> opt = repo.findById(id);
		if (!opt.isPresent())
			throw new DataNotFoundException("userDetails '" + id + "' Not Found");

		repo.deleteById(id);
	}

	@Override
	@Transactional
	public void updateRecords(Integer id) {
		String define = "Np";
		repo.updateRecords(id, define);

	}

	@Override
	public boolean isUserExist(Integer id) {
		boolean exist = repo.existsById(id);

		return exist;
	}

	@Override
	public void updateUser(UserEntity user) throws DataNotFoundException {
		Optional<UserEntity> opt = repo.findById(user.getId());
		if (!opt.isPresent()) {
			throw new DataNotFoundException("User '" + user.getId() + "' Not Found");
	    }
		repo.save(user);
	}

}
