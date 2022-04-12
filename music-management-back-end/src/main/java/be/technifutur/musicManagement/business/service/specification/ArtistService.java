package be.technifutur.musicManagement.business.service.specification;

import be.technifutur.musicManagement.model.dto.ArtistDTO;

import java.util.List;

public interface ArtistService {

    // READ
    List<ArtistDTO> getAllArtists();
    ArtistDTO getArtistById(Long id);

}
