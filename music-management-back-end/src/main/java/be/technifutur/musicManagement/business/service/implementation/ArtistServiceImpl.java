package be.technifutur.musicManagement.business.service.implementation;

import be.technifutur.musicManagement.business.mapper.ArtistMapper;
import be.technifutur.musicManagement.business.service.specification.ArtistService;
import be.technifutur.musicManagement.exception.ElementNotFoundException;
import be.technifutur.musicManagement.model.dto.ArtistDTO;
import be.technifutur.musicManagement.repository.ArtistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository repository;
    private final ArtistMapper mapper;

    @Override
    public List<ArtistDTO> getAllArtists() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public ArtistDTO getArtistById(Long id) {
        return repository.findById(id)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, ArtistDTO.class));
    }
}
