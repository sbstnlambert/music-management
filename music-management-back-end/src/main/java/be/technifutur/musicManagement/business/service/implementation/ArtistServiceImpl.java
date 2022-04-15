package be.technifutur.musicManagement.business.service.implementation;

import be.technifutur.musicManagement.business.mapper.ArtistMapper;
import be.technifutur.musicManagement.business.service.specification.ArtistService;
import be.technifutur.musicManagement.exception.ElementNotFoundException;
import be.technifutur.musicManagement.model.dto.ArtistDTO;
import be.technifutur.musicManagement.model.entity.Artist;
import be.technifutur.musicManagement.model.form.ArtistForm;
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
    public ArtistDTO getArtistById(Long id) {
        return this.repository.findById(id)
                .map(this.mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, ArtistDTO.class));
    }

    @Override
    public List<ArtistDTO> getArtistsByNameWithAutocomplete(String nameFragment) {
        return this.repository.findArtistsByNameWithAutocomplete(nameFragment)
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public List<ArtistDTO> getAllArtists() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::entityToDTO)
                .toList();
    }

    @Override
    public ArtistDTO insertArtist(ArtistForm form) {
        Artist entity = mapper.formToEntity(form);
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

}
