package be.technifutur.musicManagement.business.service.implementation;

import be.technifutur.musicManagement.business.service.specification.TrackService;
import be.technifutur.musicManagement.model.dto.TrackSimpleDTO;

import java.util.List;

public class TrackServiceImpl implements TrackService {
    @Override
    public List<TrackSimpleDTO> getTracksByAlbum(Long albumId) {
        return null;
    }
}
