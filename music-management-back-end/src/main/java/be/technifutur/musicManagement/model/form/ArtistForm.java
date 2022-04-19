package be.technifutur.musicManagement.model.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ArtistForm {

    @NotBlank(message = "Name may not be blank")
    @Size(max = 255, message = "Name must be 255 characters at maximum")
    private String name;

    @Size(max = 255, message = "Image URL must be 255 characters at maximum")
    private String imageUrl;
}
