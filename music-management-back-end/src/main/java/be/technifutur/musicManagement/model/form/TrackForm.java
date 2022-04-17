package be.technifutur.musicManagement.model.form;

import lombok.Data;

@Data
public class TrackForm {
    private String name;
    private int lengthInSeconds;
    private int albumPosition;
    private String videoUrl;
    private Long albumId;
}
