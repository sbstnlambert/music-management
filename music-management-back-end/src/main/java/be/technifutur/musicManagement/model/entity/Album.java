package be.technifutur.musicManagement.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @Column(name = "release_date", nullable = true)
    private LocalDate releaseDate;

    @Column(name = "record_label", nullable = true)
    private String recordLabel;

    @Column(name = "image_url", nullable = true)
    private String imageUrl;

    @ManyToOne
    private Artist artist;

    @OneToMany(mappedBy = "album")
    private List<Track> tracks = new ArrayList<>();

}
