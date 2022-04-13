package be.technifutur.musicManagement.repository;

import be.technifutur.musicManagement.model.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {
    @Query("SELECT t FROM Track t WHERE t.album.id = ?1")
    List<Track> findTracksByAlbum(Long albumId);
}
