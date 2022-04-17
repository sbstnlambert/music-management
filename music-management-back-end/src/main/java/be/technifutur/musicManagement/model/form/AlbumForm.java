package be.technifutur.musicManagement.model.form;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AlbumForm {
    private String name;
    private LocalDate releaseDate;
    private String recordLabel;
    private String imageUrl;
    private Long artistId;
}
