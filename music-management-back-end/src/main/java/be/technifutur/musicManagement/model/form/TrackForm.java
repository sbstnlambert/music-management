package be.technifutur.musicManagement.model.form;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class TrackForm {

    @NotBlank(message = "Name may not be blank")
    @Size(max = 255, message = "Name must be 255 characters at maximum")
    private String name;

    @Min(value = 1, message = "Length must be at least 1 second")
    private int lengthInSeconds;

    @Min(value = 1, message = "Album position must be at least 1")
    private int albumPosition;

    @NotBlank(message = "Video URL may not be blank")
    @Size(max = 255, message = "Video URL must be 255 characters at maximum")
    private String videoUrl;

    private Long albumId;
}
