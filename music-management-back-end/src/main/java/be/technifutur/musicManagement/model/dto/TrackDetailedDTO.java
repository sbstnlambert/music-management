package be.technifutur.musicManagement.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrackDetailedDTO {
    private Long id;
    private String name;
    private int lengthInSeconds;
    private int numberOfLikes;
    private int albumPosition;
}
