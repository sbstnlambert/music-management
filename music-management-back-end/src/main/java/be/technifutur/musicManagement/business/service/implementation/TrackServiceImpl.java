package be.technifutur.musicManagement.business.service.implementation;

import be.technifutur.musicManagement.business.mapper.TrackMapper;
import be.technifutur.musicManagement.business.service.specification.TrackService;
import be.technifutur.musicManagement.model.dto.TrackDetailedDTO;
import be.technifutur.musicManagement.model.dto.TrackSimpleDTO;
import be.technifutur.musicManagement.repository.TrackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
public class TrackServiceImpl implements TrackService {

    private final TrackRepository repository;
    private final TrackMapper mapper;

    @Override
    public TrackDetailedDTO getTrackById(Long id) {
        return null;
    }

    @Override
    public List<TrackSimpleDTO> getTracksByAlbum(Long albumId) {
        return this.repository.findTracksByAlbum(albumId)
                .stream()
                .map(mapper::entityToSimpleDTO)
                .toList();
    }

}
