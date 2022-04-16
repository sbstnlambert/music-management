package be.technifutur.musicManagement.business.service.specification;

import be.technifutur.musicManagement.model.dto.AlbumDTO;
import be.technifutur.musicManagement.model.form.AlbumForm;

import java.util.List;

public interface AlbumService {

    // CREATE
    AlbumDTO insertAlbum(AlbumForm form);

    // READ
    AlbumDTO getAlbumById(Long id);
    List<AlbumDTO> getAlbumsByNameWithAutocomplete(String nameFragment);
    List<AlbumDTO> getAlbumsByArtist(Long artistId);

}
