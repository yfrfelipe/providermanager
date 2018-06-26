package br.com.providermanager.model.address;

import br.com.providermanager.model.AbstractEntity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity(name = "tb_city")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class City extends AbstractEntity {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "city_gen", sequenceName = "city_seq")
    @Column(nullable = false, updatable = false)
    @NonNull
    private Integer id;

    @Column(nullable = false)
    @NonNull
    @Getter
    private String name;

    @OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @NonNull
    @Getter
    private State state;
}
