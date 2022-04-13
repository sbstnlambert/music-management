package be.technifutur.musicManagement.business.mapper;

import be.technifutur.musicManagement.model.dto.AlbumDTO;
import be.technifutur.musicManagement.model.entity.Album;
import org.springframework.stereotype.Service;

@Service
public class AlbumMapper {

    public AlbumDTO entityToDTO(Album entity) {
        if (entity == null)
            return null;

        return AlbumDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .releaseDate(entity.getReleaseDate())
                .recordLabel(entity.getRecordLabel())
                .imageUrl(entity.getImageUrl())
                .build();
    }

}
