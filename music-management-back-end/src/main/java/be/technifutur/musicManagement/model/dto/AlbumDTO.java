package be.technifutur.musicManagement.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AlbumDTO {

    private Long id;
    private String name;
    private LocalDate releaseDate;
    private String recordLabel;
    private String imageUrl;
    private Long artistId;

}
