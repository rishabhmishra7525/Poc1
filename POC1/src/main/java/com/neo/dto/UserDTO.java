/**
 * 
 */
package com.neo.dto;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;

import org.hibernate.annotations.Parent;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * @author Rishabh Mishra
 *
 */
@Data
public class UserDTO {
	
	private String firstName;
	private String lastName;
	private String pinCode;
   @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
	
}
