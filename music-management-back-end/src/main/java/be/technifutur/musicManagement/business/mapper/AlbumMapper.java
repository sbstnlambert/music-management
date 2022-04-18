package be.technifutur.musicManagement.business.mapper;

import be.technifutur.musicManagement.model.dto.AlbumDTO;
import be.technifutur.musicManagement.model.entity.Album;
import be.technifutur.musicManagement.model.form.AlbumForm;
import be.technifutur.musicManagement.repository.ArtistRepository;
import org.springframework.stereotype.Service;

@Service
public class AlbumMapper {

    private final ArtistRepository artistRepository;

    public AlbumMapper(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public AlbumDTO entityToDTO(Album entity) {
        if (entity == null)
            return null;

        return AlbumDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .releaseDate(entity.getReleaseDate())
                .recordLabel(entity.getRecordLabel())
                .imageUrl(entity.getImageUrl())
                .artistId(entity.getArtist().getId())
                .build();
    }

    public Album formToEntity(AlbumForm form) {
        if (form == null)
            return null;

        return Album.builder()
                .name(form.getName())
                .releaseDate(form.getReleaseDate())
                .recordLabel(form.getRecordLabel())
                .imageUrl(form.getImageUrl())
                .artist(
                        this.artistRepository.findById(form.getArtistId())
                                .orElse(null)
                )
                .build();
    }

}
