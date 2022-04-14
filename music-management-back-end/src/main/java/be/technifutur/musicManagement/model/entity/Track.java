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

    @Column(name = "video_url")
    private String videoUrl;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Album album;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Artist artist;

}
