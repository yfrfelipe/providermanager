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
public class CityDTO extends AbstractDTO {

    @NonNull
    @Getter
    private String name;

    @NonNull
    @Getter
    private StateDTO stateDTO;
}
