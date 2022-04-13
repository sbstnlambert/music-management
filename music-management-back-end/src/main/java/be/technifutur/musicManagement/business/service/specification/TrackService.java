package be.technifutur.musicManagement.business.service.specification;

import be.technifutur.musicManagement.model.dto.TrackSimpleDTO;

import java.util.List;

public interface TrackService {
    // READ
    List<TrackSimpleDTO> getTracksByAlbum(Long albumId);
}
