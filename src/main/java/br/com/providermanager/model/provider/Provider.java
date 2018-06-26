package br.com.providermanager.model.provider;

import br.com.providermanager.model.AbstractEntity;
import br.com.providermanager.model.address.Address;
import br.com.providermanager.model.contact.Contact;
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

@Entity(name = "tb_provider")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Provider extends AbstractEntity {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "provider_gen", sequenceName = "provider_seq")
    @Column(nullable = false, updatable = false)
    @NonNull
    private Integer id;

    @Column(nullable = false)
    @Getter
    @NonNull
    private String name;

    @Column(nullable = false)
    @Getter
    @NonNull
    private String cnpj;

    @Column(nullable = false)
    @Getter
    private String stateEnrolment;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Getter
    @NonNull
    private Contact contact;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Getter
    @NonNull
    private Address address;
}
