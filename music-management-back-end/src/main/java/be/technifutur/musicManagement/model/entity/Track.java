package be.technifutur.musicManagement.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @NotEmpty(message = "Name may not be empty")
    @Size(max = 255, message = "Name must be 255 characters at maximum")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull(message = "Length may not be null")
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

    @NotNull(message = "Album position may not be null")
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

}
