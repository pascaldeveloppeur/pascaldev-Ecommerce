package com.pascaldev.Ecommerce_user_service.model;

/**
 * @author Pascal Dev
 */

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "ecommerce-user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
	
	
	 @Serial
     static final long serialVersionUID = -4779073504124416626L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ecommerce-user_seq")
	@SequenceGenerator(name = "ecommerce-user_seq", sequenceName = "ecommerce-user_seq", initialValue = 1, allocationSize = 1)
	 Long id;

	@NotNull(message = "username cannot be null")
	@Column(name = "username", length = 20,unique = true)
     String username;
	
	@NotNull
	@Column(name = "password",unique = true)
     String password;
    
    @NotNull(message = "email cannot be null")
	@Column(name ="email", unique = true, nullable = false)
     String email;
    
    @NotNull
	@Column(name = "first_name")
    String firstName;
    
    @NotNull
	@Column(name = "last_name")
    String lastName;
  
    @NotNull
	@Enumerated(EnumType.STRING)
	 Role role;
    
    boolean enabled;
    
   
    @CreationTimestamp
    LocalDateTime  createdAt;
    
    @UpdateTimestamp
    LocalDateTime updatedAt;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
