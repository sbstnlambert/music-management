package be.technifutur.musicManagement.business.service.specification;

import be.technifutur.musicManagement.model.dto.AlbumDTO;

import java.util.List;

public interface AlbumService {

    // READ
    AlbumDTO getAlbumById(Long id);
    List<AlbumDTO> getAlbumsByNameWithAutocomplete(String nameFragment);
    List<AlbumDTO> getAlbumsByArtist(Long artistId);

}
