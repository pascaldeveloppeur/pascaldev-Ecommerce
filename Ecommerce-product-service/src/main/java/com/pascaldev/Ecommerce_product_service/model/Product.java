package com.pascaldev.Ecommerce_product_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Pascal Dev
 */
@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product  {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@SequenceGenerator(name = "product_seq", sequenceName = "product_seq", initialValue = 1, allocationSize = 1)
	Long id;

	@NotNull(message = "name cannot be null")
	@Column(name = "name")
	String name;

	@Column(name = "description", length = 100)
	String description;

	@NotNull
	String sku; // Stock Keeping Unit, identifiant unique du produit

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stock_id", referencedColumnName = "id")
	Stock stock;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "price_id", referencedColumnName = "id")
	Price price;

	@ManyToOne
	@JoinColumn(name = "category_id")
	Category category;

	@CreationTimestamp
	LocalDateTime createdAt;

	@UpdateTimestamp
	LocalDateTime updatedAt;

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		Product product = (Product) o;
		return getId() != null && Objects.equals(getId(), product.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}
