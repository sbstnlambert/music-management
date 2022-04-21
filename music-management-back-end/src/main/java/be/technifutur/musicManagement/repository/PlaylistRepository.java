package be.technifutur.musicManagement.repository;

import be.technifutur.musicManagement.model.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    @Query("SELECT p FROM Playlist p WHERE p.user.username = ?1")
    List<Playlist> findPlaylistsByUser(String username);

}
