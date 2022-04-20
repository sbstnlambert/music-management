package be.technifutur.musicManagement.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = "artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Name may not be blank")
    @Size(max = 255, message = "Name must be 255 characters at maximum")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Size(max = 255, message = "Image URL must be 255 characters at maximum")
    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(
            mappedBy = "artist",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Album> albums = new ArrayList<>();

    @OneToMany(
            mappedBy = "artist",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Track> tracks = new ArrayList<>();

}
