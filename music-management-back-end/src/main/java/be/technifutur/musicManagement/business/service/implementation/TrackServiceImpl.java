package be.technifutur.musicManagement.business.service.implementation;

import be.technifutur.musicManagement.business.mapper.TrackMapper;
import be.technifutur.musicManagement.business.service.specification.TrackService;
import be.technifutur.musicManagement.exception.ElementNotFoundException;
import be.technifutur.musicManagement.model.dto.TrackDetailedDTO;
import be.technifutur.musicManagement.model.dto.TrackSimpleDTO;
import be.technifutur.musicManagement.model.entity.Track;
import be.technifutur.musicManagement.model.form.TrackForm;
import be.technifutur.musicManagement.repository.TrackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TrackServiceImpl implements TrackService {

    private final TrackRepository repository;
    private final TrackMapper mapper;

    @Override
    public TrackDetailedDTO getTrackById(Long id) {
        return this.repository.findById(id)
                .map(mapper::entityToDetailedDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, TrackDetailedDTO.class));
    }

    @Override
    public List<TrackSimpleDTO> getTracksByNameWithAutocomplete(String nameFragment) {
        return this.repository.findTracksByNameWithAutocomplete(nameFragment)
                .stream()
                .map(mapper::entityToSimpleDTO)
                .toList();
    }

    @Override
    public List<TrackSimpleDTO> getTracksByAlbum(Long albumId) {
        return this.repository.findTracksByAlbum(albumId)
                .stream()
                .map(mapper::entityToSimpleDTO)
                .toList();
    }

    @Override
    public List<TrackSimpleDTO> getTracksByArtist(Long artistId) {
        return this.repository.findTracksByArtist(artistId)
                .stream()
                .map(mapper::entityToSimpleDTO)
                .toList();
    }

    @Override
    public TrackSimpleDTO insertTrack(TrackForm form) {
        Track entity = mapper.formToEntity(form);
        entity = repository.save(entity);
        return mapper.entityToSimpleDTO(entity);
    }

    @Override
    public TrackSimpleDTO deleteTrackById(Long id) {
        Track deleted = this.repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, Track.class));
        this.repository.deleteById(id);
        return this.mapper.entityToSimpleDTO(deleted);
    }

}
