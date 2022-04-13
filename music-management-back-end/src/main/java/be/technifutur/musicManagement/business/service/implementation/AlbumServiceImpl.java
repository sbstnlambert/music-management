package be.technifutur.musicManagement.business.service.implementation;

import be.technifutur.musicManagement.business.mapper.AlbumMapper;
import be.technifutur.musicManagement.business.service.specification.AlbumService;
import be.technifutur.musicManagement.model.dto.AlbumDTO;
import be.technifutur.musicManagement.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository repository;
    private final AlbumMapper mapper;

    public AlbumServiceImpl(AlbumRepository repository, AlbumMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<AlbumDTO> getAlbumsByArtist(Long artistId) {
        return this.repository
                .findAlbumsByArtist(artistId)
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }

}
