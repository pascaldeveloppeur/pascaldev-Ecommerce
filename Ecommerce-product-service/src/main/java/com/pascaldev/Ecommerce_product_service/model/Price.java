package com.pascaldev.Ecommerce_product_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "prices")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Price {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prices_id_seq")
	@SequenceGenerator(name = "prices_id_seq", sequenceName = "prices_id_seq", initialValue = 1, allocationSize = 1)
    Long id;

    @NotNull
    BigDecimal amount; // Prix actuel

    BigDecimal discount; // Remise éventuelle

    LocalDateTime startDate; // Date de début du prix
    LocalDateTime endDate;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Price price = (Price) o;
        return getId() != null && Objects.equals(getId(), price.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
