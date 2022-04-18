package be.technifutur.musicManagement.business.service.specification;

import be.technifutur.musicManagement.model.dto.ArtistDTO;
import be.technifutur.musicManagement.model.form.ArtistForm;

import java.util.List;

public interface ArtistService {

    // CREATE
    ArtistDTO insertArtist(ArtistForm form);

    // READ
    ArtistDTO getArtistById(Long id);
    List<ArtistDTO> getArtistsByNameWithAutocomplete(String nameFragment);
    List<ArtistDTO> getAllArtists();

    // DELETE
    ArtistDTO deleteArtistById(Long id);
}
