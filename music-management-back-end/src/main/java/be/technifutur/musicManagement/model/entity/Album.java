package be.technifutur.musicManagement.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Name may not be blank")
    @Size(max = 255, message = "Name must be 255 characters at maximum")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Size(max = 255, message = "Record label must be 255 characters at maximum")
    @Column(name = "record_label")
    private String recordLabel;

    @Size(max = 255, message = "Image URL must be 255 characters at maximum")
    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    private Artist artist;

    @OneToMany(
            mappedBy = "album",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Track> tracks = new ArrayList<>();

    @ManyToMany
    private List<Genre> genres = new ArrayList<>();

}
