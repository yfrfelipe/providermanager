package br.com.providermanager.dto.address;

import br.com.providermanager.dto.AbstractDTO;
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
public class AddressDTO extends AbstractDTO {

    @NonNull
    @Getter
    private String street;

    @NonNull
    @Getter
    private String number;

    @NonNull
    @Getter
    private String neighbor;

    @NonNull
    @Getter
    private String cep;

    @Getter
    @NonNull
    private CityDTO cityDTO;
}
