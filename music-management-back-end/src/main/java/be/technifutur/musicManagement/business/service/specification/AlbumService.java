package be.technifutur.musicManagement.business.service.specification;

import be.technifutur.musicManagement.model.dto.AlbumDTO;

import java.util.List;

public interface AlbumService {

    // READ
    List<AlbumDTO> getAlbumsByArtist(Long artistId);

}
