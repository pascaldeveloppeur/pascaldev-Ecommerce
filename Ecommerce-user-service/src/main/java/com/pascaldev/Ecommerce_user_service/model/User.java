package com.pascaldev.Ecommerce_user_service.model;

/**
 * @author Pascal Dev
 */

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ecommerce-user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User implements Serializable {
	
	
	private static final long serialVersionUID = -4779073504124416626L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ecommerce-user_seq")
	@SequenceGenerator(name = "ecommerce-user_seq", sequenceName = "ecommerce-user_seq", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@NotNull(message = "username cannot be null")
	@Column(name = "name", length = 20)
    private String username;
    private String password;
    private String email;

}
