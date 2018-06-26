package br.com.providermanager.dto.provider;

import br.com.providermanager.dto.AbstractDTO;
import br.com.providermanager.dto.address.AddressDTO;
import br.com.providermanager.dto.contact.ContactDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@JsonIgnoreProperties
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProviderDTO extends AbstractDTO {

    @Getter
    @NonNull
    private String name;

    @Getter
    @NonNull
    private String cnpj;

    @Getter
    private String stateEnrolment;

    @Getter
    @NonNull
    private ContactDTO contact;

    @Getter
    @NonNull
    private AddressDTO address;
}
