package be.technifutur.musicManagement.business.service.implementation;

import be.technifutur.musicManagement.business.mapper.AlbumMapper;
import be.technifutur.musicManagement.business.service.specification.AlbumService;
import be.technifutur.musicManagement.exception.ElementNotFoundException;
import be.technifutur.musicManagement.model.dto.AlbumDTO;
import be.technifutur.musicManagement.model.entity.Album;
import be.technifutur.musicManagement.model.form.AlbumForm;
import be.technifutur.musicManagement.repository.AlbumRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository repository;
    private final AlbumMapper mapper;

    @Override
    public AlbumDTO getAlbumById(Long id) {
        return this.repository.findById(id)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, AlbumDTO.class));
    }

    @Override
    public List<AlbumDTO> getAlbumsByNameWithAutocomplete(String nameFragment) {
        return this.repository.findAlbumsByNameWithAutocomplete(nameFragment)
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    public List<AlbumDTO> getAlbumsByArtist(Long artistId) {
        return this.repository
                .findAlbumsByArtist(artistId)
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public AlbumDTO insertAlbum(AlbumForm form) {
        Album entity = mapper.formToEntity(form);
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

}
