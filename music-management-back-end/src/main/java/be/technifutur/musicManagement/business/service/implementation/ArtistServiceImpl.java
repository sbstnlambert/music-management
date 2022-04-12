package be.technifutur.musicManagement.business.service.implementation;

import be.technifutur.musicManagement.business.mapper.ArtistMapper;
import be.technifutur.musicManagement.business.service.specification.ArtistService;
import be.technifutur.musicManagement.model.dto.ArtistDTO;
import be.technifutur.musicManagement.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository repository;
    private final ArtistMapper mapper;

    public ArtistServiceImpl(ArtistRepository repository, ArtistMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ArtistDTO> getAllArtists() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }
}
