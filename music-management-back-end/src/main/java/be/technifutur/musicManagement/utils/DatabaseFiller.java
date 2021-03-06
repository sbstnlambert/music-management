package be.technifutur.musicManagement.utils;

import be.technifutur.musicManagement.model.entity.*;
import be.technifutur.musicManagement.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class DatabaseFiller implements InitializingBean {

    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;
    private final TrackRepository trackRepository;
    private final GenreRepository genreRepository;
    private final UserRepository userRepository;
    private final PlaylistRepository playlistRepository;
    private final PasswordEncoder encoder;

    @Override
    public void afterPropertiesSet() throws Exception {

        // region ARTIST
        Artist twentyOnePilots = Artist.builder()
                .name("Twenty One Pilots")
                .imageUrl("3Kv4h9I")
                .build();
        artistRepository.save(twentyOnePilots);

        Artist maskedWolf = Artist.builder()
                .name("Masked Wolf")
                .imageUrl("3Kyjsio")
                .build();
        artistRepository.save(maskedWolf);

        Artist jacquesBrel = Artist.builder()
                .name("Jacques Brel")
                .imageUrl("37GLvhh")
                .build();
        artistRepository.save(jacquesBrel);

        Artist architects = Artist.builder()
                .name("Architects")
                .imageUrl("3KPEUzP")
                .build();
        artistRepository.save(architects);

        Artist muse = Artist.builder()
                .name("Muse")
                .imageUrl("3JymP7G")
                .build();
        artistRepository.save(muse);

        Artist orelsan = Artist.builder()
                .name("Orelsan")
                .imageUrl("3KAkMBv")
                .build();
        artistRepository.save(orelsan);

        Artist rammstein = Artist.builder()
                .name("Rammstein")
                .imageUrl("3E4Cevg")
                .build();
        artistRepository.save(rammstein);

        Artist keryJames = Artist.builder()
                .name("Kery James")
                .imageUrl("3E5lofY")
                .build();
        artistRepository.save(keryJames);

        Artist token = Artist.builder()
                .name("Token")
                .imageUrl("3JygEAC")
                .build();
        artistRepository.save(token);

        Artist jeanFerrat = Artist.builder()
                .name("Jean Ferrat")
                .imageUrl("3JwWrer")
                .build();
        artistRepository.save(jeanFerrat);

        Artist imagineDragons = Artist.builder()
                .name("Imagine Dragons")
                .imageUrl("3KEi4uS")
                .build();
        artistRepository.save(imagineDragons);
        //endregion

        // region GENRE
        Genre hipHop = Genre.builder()
                .name("Hip-Hop")
                .build();
        genreRepository.save(hipHop);

        Genre rap = Genre.builder()
                .name("Rap")
                .build();
        genreRepository.save(rap);

        Genre rock = Genre.builder()
                .name("Rock")
                .build();
        genreRepository.save(rock);

        Genre metal = Genre.builder()
                .name("Metal")
                .build();
        genreRepository.save(metal);

        Genre pop = Genre.builder()
                .name("Pop")
                .build();
        genreRepository.save(pop);

        Genre french = Genre.builder()
                .name("French")
                .build();
        genreRepository.save(french);
        //endregion

        // region ALBUM
        Album trench = Album.builder()
                .name("Trench")
                .releaseDate(LocalDate.of(2018, 10, 17))
                .recordLabel("Fueled By Ramen")
                .imageUrl("3jx0uwT")
                .artist(twentyOnePilots)
                .genres(Arrays.asList(rock, hipHop, rap))
                .build();
        albumRepository.save(trench);

        Album blurryFace = Album.builder()
                .name("Blurry Face")
                .releaseDate(LocalDate.of(2015, 10, 11))
                .recordLabel("Fueled By Ramen")
                .imageUrl("3KFCvre")
                .artist(twentyOnePilots)
                .genres(Arrays.asList(pop, hipHop))
                .build();
        albumRepository.save(blurryFace);

        Album scaledAndIcy = Album.builder()
                .name("Scaled And Icy")
                .releaseDate(LocalDate.of(2021, 5, 10))
                .recordLabel("Fueled By Ramen")
                .imageUrl("3JxHA3j")
                .artist(twentyOnePilots)
                .genres(Arrays.asList(pop, hipHop))
                .build();
        albumRepository.save(scaledAndIcy);

        Album astronomical = Album.builder()
                .name("Astronomical")
                .releaseDate(LocalDate.of(2021, 8, 10))
                .recordLabel("New Space Rap")
                .imageUrl("3JDb3sE")
                .artist(maskedWolf)
                .genres(List.of(rap, hipHop))
                .build();
        albumRepository.save(astronomical);

        Album deutschland = Album.builder()
                .name("Deutschland")
                .releaseDate(LocalDate.of(2019, 4, 27))
                .recordLabel("Rammstein record")
                .imageUrl("3xrJ1Ot")
                .artist(rammstein)
                .genres(List.of(metal))
                .build();
        albumRepository.save(deutschland);
        //endregion

        // region TRACK
        Track jumpsuit = Track.builder()
                .name("Jumpsuit")
                .lengthInSeconds(299)
                .numberOfLikes(116452548L)
                .albumPosition(1)
                .album(trench)
                .artist(twentyOnePilots)
                .videoUrl("UOUBW8bkjQ4")
                .build();
        trackRepository.save(jumpsuit);

        Track levitate = Track.builder()
                .name("Levitate")
                .lengthInSeconds(154)
                .numberOfLikes(38584678L)
                .albumPosition(2)
                .album(trench)
                .artist(twentyOnePilots)
                .videoUrl("uv_1AKKKJnk")
                .build();
        trackRepository.save(levitate);

        Track morph = Track.builder()
                .name("Morph")
                .lengthInSeconds(260)
                .numberOfLikes(33996404L)
                .albumPosition(3)
                .album(trench)
                .artist(twentyOnePilots)
                .videoUrl("OmL9TqTFIAc")
                .build();
        trackRepository.save(morph);

        Track myBlood = Track.builder()
                .name("My Blood")
                .lengthInSeconds(236)
                .numberOfLikes(83328040L)
                .albumPosition(4)
                .album(trench)
                .artist(twentyOnePilots)
                .videoUrl("8mn-FFjIbo8")
                .build();
        trackRepository.save(myBlood);

        Track astronomicalTrack = Track.builder()
                .name("Astronomical")
                .lengthInSeconds(196)
                .numberOfLikes(197002L)
                .albumPosition(1)
                .album(astronomical)
                .artist(maskedWolf)
                .videoUrl("w_u8_gJsaAg")
                .build();
        trackRepository.save(astronomicalTrack);

        Track gravityGlidin = Track.builder()
                .name("Gravity Glidin")
                .lengthInSeconds(141)
                .numberOfLikes(2426700L)
                .albumPosition(2)
                .album(astronomical)
                .artist(maskedWolf)
                .videoUrl("3NmmMcQ_6lY")
                .build();
        trackRepository.save(gravityGlidin);

        Track deutschlandTrack = Track.builder()
                .name("Deutschland")
                .lengthInSeconds(365)
                .numberOfLikes(2400000L)
                .albumPosition(1)
                .album(deutschland)
                .artist(rammstein)
                .videoUrl("Z4ZrzuZLuC4")
                .build();
        trackRepository.save(deutschlandTrack);
        //endregion

        // region USER
        User lionel = new User();
        lionel.setUsername("lionel");
        lionel.setPassword(this.encoder.encode("lionel"));
        lionel.setEmail("lionel.test@security.com");
        lionel.setRoles(List.of("ROLE_USER"));
        userRepository.save(lionel);

        User seb = new User();
        seb.setUsername("sebastien");
        seb.setPassword(this.encoder.encode("sebastien"));
        seb.setEmail("sebastien.test@security.com");
        seb.setRoles(List.of("ROLE_USER"));
        userRepository.save(seb);

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(this.encoder.encode("admin"));
        admin.setEmail("admin.test@security.com");
        admin.setRoles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
        userRepository.save(admin);
        // endregion

        // region PLAYLIST
        Playlist p1Lio = new Playlist();
        p1Lio.setName("Liked tracks");
        p1Lio.setUser(lionel);
        playlistRepository.save(p1Lio);

        Playlist p2Lio = new Playlist();
        p2Lio.setName("Hip");
        p2Lio.setUser(lionel);
        p2Lio.setTracks(Arrays.asList(
                deutschlandTrack,
                jumpsuit
        ));
        playlistRepository.save(p2Lio);

        Playlist p1Seb = new Playlist();
        p1Seb.setName("Liked tracks");
        p1Seb.setUser(seb);
        playlistRepository.save(p1Seb);

        Playlist p2Seb = new Playlist();
        p2Seb.setName("Masked Wolf preferred");
        p2Seb.setUser(seb);
        p2Seb.setTracks(Arrays.asList(
                astronomicalTrack,
                gravityGlidin
        ));
        playlistRepository.save(p2Seb);

        Playlist p1Admin = new Playlist();
        p1Admin.setName("Liked tracks");
        p1Admin.setUser(admin);
        playlistRepository.save(p1Admin);
        // endregion

    }

}
