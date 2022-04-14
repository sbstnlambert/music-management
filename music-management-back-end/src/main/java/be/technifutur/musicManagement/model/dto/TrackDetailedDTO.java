package be.technifutur.musicManagement.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrackDetailedDTO {

    private Long id;
    private String name;
    private int lengthInSeconds;
    private Long numberOfLikes;
    private String artistName;
    private String albumName;
    private String[] albumGenres;

}