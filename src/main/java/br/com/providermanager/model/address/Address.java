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

@Entity(name = "tb_address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Address extends AbstractEntity {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "address_gen", sequenceName = "address_seq")
    @Column(nullable = false, updatable = false)
    @NonNull
    private Integer id;

    @Column(nullable = false)
    @NonNull
    @Getter
    private String street;

    @Column(nullable = false)
    @NonNull
    @Getter
    private String number;

    @Column(nullable = false)
    @NonNull
    @Getter
    private String neighbor;

    @Column(nullable = false)
    @NonNull
    @Getter
    private String cep;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Getter
    @NonNull
    private City city;
}
