package be.technifutur.musicManagement.model.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class AlbumForm {

    @NotBlank(message = "Name may not be blank")
    @Size(max = 255, message = "Name must be 255 characters at maximum")
    private String name;

    @PastOrPresent(message = "Release date must be in past or present")
    private LocalDate releaseDate;

    @Size(max = 255, message = "Record label must be 255 characters at maximum")
    private String recordLabel;

    @Size(max = 255, message = "Image URL must be 255 characters at maximum")
    private String imageUrl;

    private Long artistId;
}
