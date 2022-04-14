package be.technifutur.musicManagement.business.mapper;

import be.technifutur.musicManagement.model.dto.TrackDetailedDTO;
import be.technifutur.musicManagement.model.dto.TrackSimpleDTO;
import be.technifutur.musicManagement.model.entity.Genre;
import be.technifutur.musicManagement.model.entity.Track;
import org.springframework.stereotype.Service;

@Service
public class TrackMapper {
    public TrackSimpleDTO entityToSimpleDTO(Track entity) {
        if (entity == null)
            return null;

        return TrackSimpleDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .albumPosition(entity.getAlbumPosition())
                .numberOfLikes(entity.getNumberOfLikes())
                .build();
    }

    public TrackDetailedDTO entityToDetailedDTO(Track entity) {
        if (entity == null)
            return null;

        return TrackDetailedDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lengthInSeconds(entity.getLengthInSeconds())
                .numberOfLikes(entity.getNumberOfLikes())
                .artistName(entity.getArtist().getName())
                .albumName(entity.getAlbum().getName())
                .albumGenres(
                        entity.getAlbum()
                                .getGenres()
                                .stream()
                                .map(Genre::getName)
                                .toList()
                )
                .videoUrl(entity.getVideoUrl())
                .build();
    }
}
