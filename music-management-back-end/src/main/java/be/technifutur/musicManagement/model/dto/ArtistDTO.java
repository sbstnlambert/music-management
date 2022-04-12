package be.technifutur.musicManagement.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArtistDTO {

    private Long id;
    private String name;

}
