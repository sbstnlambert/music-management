package be.technifutur.musicManagement.repository;

import be.technifutur.musicManagement.model.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
