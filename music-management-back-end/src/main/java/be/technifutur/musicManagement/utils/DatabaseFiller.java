package be.technifutur.musicManagement.utils;

import be.technifutur.musicManagement.model.entity.Artist;
import be.technifutur.musicManagement.repository.ArtistRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFiller implements InitializingBean {

    private final ArtistRepository artistRepository;

    public DatabaseFiller(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

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

    }
}
