package be.technifutur.musicManagement.business.service.specification;

import be.technifutur.musicManagement.model.dto.ArtistDTO;
import be.technifutur.musicManagement.model.form.ArtistForm;

import java.util.List;

public interface ArtistService {

    // CREATE
    ArtistDTO insertArtist(ArtistForm form);

    // READ
    List<ArtistDTO> getAllArtists();
    ArtistDTO getArtistById(Long id);

}
