package be.technifutur.musicManagement.business.service.specification;

import be.technifutur.musicManagement.model.dto.TrackDetailedDTO;
import be.technifutur.musicManagement.model.dto.TrackSimpleDTO;

import java.util.List;

public interface TrackService {

    // READ
    TrackDetailedDTO getTrackById(Long id);
    List<TrackSimpleDTO> getTracksByNameWithAutocomplete(String nameFragment);
    List<TrackSimpleDTO> getTracksByAlbum(Long albumId);
    List<TrackSimpleDTO> getTracksByArtist(Long artistId);

}
