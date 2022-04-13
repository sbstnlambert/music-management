package be.technifutur.musicManagement.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrackSimpleDTO {

    private Long id;
    private String name;
    private int numberOfLikes;

}
