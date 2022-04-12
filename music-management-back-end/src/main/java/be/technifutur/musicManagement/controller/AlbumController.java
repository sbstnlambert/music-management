package be.technifutur.musicManagement.controller;

import be.technifutur.musicManagement.business.service.specification.AlbumService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/album")
public class AlbumController {

    private final AlbumService service;

    public AlbumController(AlbumService service) {
        this.service = service;
    }

    // GET - http://localhost:8080/album/artist/artistId

}
