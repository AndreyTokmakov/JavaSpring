package service_users_and_balances.model.entities;


import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@NoArgsConstructor
public class SpotBalance extends BalanceBase {
    @Column
    private BigDecimal free;

    @Column
    private BigDecimal locked;
}
