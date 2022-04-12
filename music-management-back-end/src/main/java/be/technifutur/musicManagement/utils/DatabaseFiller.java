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
                .build();
        artistRepository.save(twentyOnePilots);

        Artist maskedWolf = Artist.builder()
                .name("Masked Wolf")
                .build();
        artistRepository.save(maskedWolf);

        Artist architects = Artist.builder()
                .name("Architects")
                .build();
        artistRepository.save(architects);

    }
}
