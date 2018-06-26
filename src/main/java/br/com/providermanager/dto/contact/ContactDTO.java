package br.com.providermanager.dto.contact;

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
public class ContactDTO extends AbstractDTO {

    @Getter
    @NonNull
    private String primaryPhone;

    @Getter
    @NonNull
    private String secondaryPhone;

    @Getter
    @NonNull
    private String email;
}
