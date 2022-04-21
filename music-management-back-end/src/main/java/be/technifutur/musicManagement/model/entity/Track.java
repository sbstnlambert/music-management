package be.technifutur.musicManagement.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = "track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Name may not be blank")
    @Size(max = 255, message = "Name must be 255 characters at maximum")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(
        name = "length_in_seconds",
        columnDefinition = "INT(11)",
        nullable = false
    )
    private int lengthInSeconds;

    @Column(
        name = "number_of_likes",
        nullable = false
    )
    private Long numberOfLikes;

    @Column(
        name = "album_position",
        columnDefinition = "INT(11)",
        nullable = false
    )
    private int albumPosition;

    @NotBlank(message = "Video URL may not be blank")
    @Size(max = 255, message = "Video URL must be 255 characters at maximum")
    @Column(name = "video_url")
    private String videoUrl;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Album album;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Artist artist;

    @ManyToMany(mappedBy = "tracks")
    private List<Playlist> playlists = new ArrayList<>();

}
