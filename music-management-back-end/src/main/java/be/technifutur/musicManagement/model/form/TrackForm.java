package be.technifutur.musicManagement.model.form;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class TrackForm {

    @NotBlank(message = "Name may not be blank")
    @Size(max = 255, message = "Name must be 255 characters at maximum")
    private String name;

    @NotNull(message = "Length may not be null")
    @Min(value = 1, message = "Length must be at least 1 second")
    private int lengthInSeconds;

    @NotNull(message = "Album position may not be null")
    private int albumPosition;

    @NotBlank(message = "Video URL may not be blank")
    @Size(max = 255, message = "Video URL must be 255 characters at maximum")
    private String videoUrl;

    private Long albumId;
}
