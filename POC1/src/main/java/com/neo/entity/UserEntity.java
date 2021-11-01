/**
 * 
 */
package com.neo.entity;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rishabh Mishra
 *
 */
@Data
@Entity
@Table(name="user_details")
@NoArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="first_Name", nullable = false)
	private String firstName;
	@Column(name="last_Name", nullable = false)
	private String lastName;
	@Column(name="email", nullable = false)
	private String email;
	@Column(name="pin_Code", nullable = false)
	private String pinCode;
	
	private String  status;
	
	 @JsonFormat(pattern = "dd-MM-yyyy")
	  private LocalDate birthday;
	
	 @Column(name = "create_date")
		private Timestamp createDate;

		@Column(name = "last_update")
		private Timestamp lastUpdate;

	
	
	
}
