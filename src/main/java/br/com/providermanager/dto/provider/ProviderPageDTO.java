package br.com.providermanager.dto.provider;

import br.com.providermanager.dto.AbstractPageDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@JsonIgnoreProperties
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProviderPageDTO extends AbstractPageDTO<ProviderDTO> {

    @Getter
    @NonNull
    private Long totalElements;
    @Getter
    @NonNull
    private Integer totalPages;
    @Getter
    @NonNull
    private List<ProviderDTO> content;
}
