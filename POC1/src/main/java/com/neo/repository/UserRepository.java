/**
 * 
 */
package com.neo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.neo.entity.UserEntity;

/**
 * @author Rishabh Mishra
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	@Query(value = "SELECT * FROM user_details where(:firstName is null or first_name  ilike %:firstName%) And (:lastName is null or last_name ilike %:lastName%) And(:pincode is null or pin_code ilike %:pincode%) ", nativeQuery = true)
	List<UserEntity> findByRecords(String firstName, String lastName, String pincode);

	
	@Modifying
	@Query(value = "UPDATE user_details SET status=:define  where id =:id ", nativeQuery = true)
	void updateRecords(Integer id, String define);


	@Query(value = "SELECT * FROM public.user_details ORDER BY create_date ASC;", nativeQuery = true)
	List<UserEntity> findAllSortingOrderASC();
	@Query(value = "SELECT * FROM public.user_details ORDER BY create_date DESC ", nativeQuery = true)
	List<UserEntity> findAllSortingOrderDSC();


	@Query(value = "SELECT * FROM public.user_details ORDER BY birthday ASC ", nativeQuery = true)
	List<UserEntity> findAlldobOrderASC();


	@Query(value = "SELECT * FROM public.user_details ORDER BY birthday DESC ", nativeQuery = true)
	List<UserEntity> findAllfindAlldobOrderOrderDSC();



}
