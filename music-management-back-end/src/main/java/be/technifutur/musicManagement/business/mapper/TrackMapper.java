package be.technifutur.musicManagement.business.mapper;

import be.technifutur.musicManagement.model.dto.TrackDetailedDTO;
import be.technifutur.musicManagement.model.dto.TrackSimpleDTO;
import be.technifutur.musicManagement.model.entity.Album;
import be.technifutur.musicManagement.model.entity.Genre;
import be.technifutur.musicManagement.model.entity.Track;
import be.technifutur.musicManagement.model.form.TrackForm;
import be.technifutur.musicManagement.repository.AlbumRepository;
import org.springframework.stereotype.Service;

@Service
public class TrackMapper {

    private final AlbumRepository albumRepository;

    public TrackMapper(AlbumRepository repository) {
        this.albumRepository = repository;
    }

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

    public Track formToEntity(TrackForm form) {
        if (form == null)
            return null;

        Album currentAlbum = this.albumRepository.findById(form.getAlbumId()).orElse(new Album());
        return Track.builder()
                .name(form.getName())
                .lengthInSeconds(form.getLengthInSeconds())
                .numberOfLikes(0L)
                .albumPosition(form.getAlbumPosition())
                .videoUrl(form.getVideoUrl())
                .album(currentAlbum)
                .artist(currentAlbum.getArtist())
                .build();
    }
}
