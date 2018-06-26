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
public class StateDTO extends AbstractDTO {

    @Getter
    @NonNull
    private String name;
}
