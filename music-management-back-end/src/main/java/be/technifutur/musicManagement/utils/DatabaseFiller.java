package be.technifutur.musicManagement.utils;

import be.technifutur.musicManagement.model.entity.Album;
import be.technifutur.musicManagement.model.entity.Artist;
import be.technifutur.musicManagement.model.entity.Track;
import be.technifutur.musicManagement.repository.AlbumRepository;
import be.technifutur.musicManagement.repository.ArtistRepository;
import be.technifutur.musicManagement.repository.TrackRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class DatabaseFiller implements InitializingBean {

    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;
    private final TrackRepository trackRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        /* ARTIST CREATION */

        Artist twentyOnePilots = Artist.builder()
                .name("Twenty One Pilots")
                .imageUrl("https://bit.ly/3Kv4h9I")
                .build();
        artistRepository.save(twentyOnePilots);

        Artist maskedWolf = Artist.builder()
                .name("Masked Wolf")
                .imageUrl("https://bit.ly/3Kyjsio")
                .build();
        artistRepository.save(maskedWolf);

        Artist jacquesBrel = Artist.builder()
                .name("Jacques Brel")
                .imageUrl("https://bit.ly/37GLvhh")
                .build();
        artistRepository.save(jacquesBrel);

        Artist architects = Artist.builder()
                .name("Architects")
                .imageUrl("https://bit.ly/3KPEUzP")
                .build();
        artistRepository.save(architects);

        Artist muse = Artist.builder()
                .name("Muse")
                .imageUrl("https://bit.ly/3JymP7G")
                .build();
        artistRepository.save(muse);

        Artist orelsan = Artist.builder()
                .name("Orelsan")
                .imageUrl("https://bit.ly/3KAkMBv")
                .build();
        artistRepository.save(orelsan);

        Artist rammstein = Artist.builder()
                .name("Rammstein")
                .imageUrl("https://bit.ly/3E4Cevg")
                .build();
        artistRepository.save(rammstein);

        Artist keryJames = Artist.builder()
                .name("Kery James")
                .imageUrl("https://bit.ly/3E5lofY")
                .build();
        artistRepository.save(keryJames);

        Artist token = Artist.builder()
                .name("Token")
                .imageUrl("https://bit.ly/3JygEAC")
                .build();
        artistRepository.save(token);

        Artist jeanFerrat = Artist.builder()
                .name("Jean Ferrat")
                .imageUrl("https://bit.ly/3JwWrer")
                .build();
        artistRepository.save(jeanFerrat);

        Artist imagineDragons = Artist.builder()
                .name("Imagine Dragons")
                .imageUrl("https://bit.ly/3KEi4uS")
                .build();
        artistRepository.save(imagineDragons);

        /* ALBUM CREATION */

        Album trench = Album.builder()
                .name("Trench")
                .releaseDate(LocalDate.of(2018, 10, 17))
                .recordLabel("Fueled By Ramen")
                .imageUrl("https://bit.ly/3jx0uwT")
                .artist(twentyOnePilots)
                .build();
        albumRepository.save(trench);

        Album blurryFace = Album.builder()
                .name("Blurry Face")
                .releaseDate(LocalDate.of(2015, 10, 11))
                .recordLabel("Fueled By Ramen")
                .imageUrl("https://bit.ly/3KFCvre")
                .artist(twentyOnePilots)
                .build();
        albumRepository.save(blurryFace);

        Album scaledAndIcy = Album.builder()
                .name("Scaled And Icy")
                .releaseDate(LocalDate.of(2021, 5, 10))
                .recordLabel("Fueled By Ramen")
                .imageUrl("https://bit.ly/3JxHA3j")
                .artist(twentyOnePilots)
                .build();
        albumRepository.save(scaledAndIcy);

        Album astronomical = Album.builder()
                .name("Astronomical")
                .releaseDate(LocalDate.of(2021, 8, 10))
                .recordLabel("New Space Rap")
                .imageUrl("https://bit.ly/3JDb3sE")
                .artist(maskedWolf)
                .build();
        albumRepository.save(astronomical);

        /* TRACK CREATION */

        Track jumpsuit = Track.builder()
                .name("Jumpsuit")
                .lengthInSeconds(299)
                .numberOfLikes(116452548)
                .albumPosition(1)
                .album(trench)
                .artist(twentyOnePilots)
                .build();
        trackRepository.save(jumpsuit);

        Track levitate = Track.builder()
                .name("Levitate")
                .lengthInSeconds(154)
                .numberOfLikes(38584678)
                .albumPosition(2)
                .album(trench)
                .artist(twentyOnePilots)
                .build();
        trackRepository.save(levitate);

        Track morph = Track.builder()
                .name("Morph")
                .lengthInSeconds(260)
                .numberOfLikes(33996404)
                .albumPosition(3)
                .album(trench)
                .artist(twentyOnePilots)
                .build();
        trackRepository.save(morph);

        Track myBlood = Track.builder()
                .name("MyBlood")
                .lengthInSeconds(236)
                .numberOfLikes(83328040)
                .albumPosition(4)
                .album(trench)
                .artist(twentyOnePilots)
                .build();
        trackRepository.save(myBlood);

        Track astronomicalTrack = Track.builder()
                .name("Astronomical")
                .lengthInSeconds(196)
                .numberOfLikes(197002)
                .albumPosition(1)
                .album(astronomical)
                .artist(maskedWolf)
                .build();
        trackRepository.save(astronomicalTrack);

        Track gravityGlidin = Track.builder()
                .name("Gravity Glidin")
                .lengthInSeconds(141)
                .numberOfLikes(2426700)
                .albumPosition(2)
                .album(astronomical)
                .artist(maskedWolf)
                .build();
        trackRepository.save(gravityGlidin);
    }

}
