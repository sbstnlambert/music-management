package be.technifutur.musicManagement.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "record_label")
    private String recordLabel;

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
