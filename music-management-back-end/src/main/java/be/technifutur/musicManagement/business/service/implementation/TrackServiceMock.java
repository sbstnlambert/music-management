package be.technifutur.musicManagement.business.service.implementation;

import be.technifutur.musicManagement.business.service.specification.TrackService;
import be.technifutur.musicManagement.model.dto.TrackDetailedDTO;
import be.technifutur.musicManagement.model.dto.TrackSimpleDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackServiceMock implements TrackService {

    @Override
    public TrackDetailedDTO getTrackById(Long id) {
        return TrackDetailedDTO.builder()
                .id(1L)
                .name("Jumpsuit")
                .lengthInSeconds(299)
                .numberOfLikes(116452548L)
                .artistName("Twenty One Pilots")
                .albumName("Trench")
                .albumGenres(new String[]{
                        "Alternative hip-hop",
                        "Alternative rock"
                })
                .build();

    }

    @Override
    public List<TrackSimpleDTO> getTracksByAlbum(Long albumId) {
        List<TrackSimpleDTO> mockList = new ArrayList<>();
        mockList.add(
                TrackSimpleDTO.builder()
                        .id(1L)
                        .name("Jumpsuit")
                        .albumPosition(1)
                        .numberOfLikes(116452548L)
                        .build()
        );

        mockList.add(
                TrackSimpleDTO.builder()
                        .id(2L)
                        .name("Levitate")
                        .albumPosition(2)
                        .numberOfLikes(38584678L)
                        .build()
        );

        mockList.add(
                TrackSimpleDTO.builder()
                        .id(3L)
                        .name("Morph")
                        .albumPosition(3)
                        .numberOfLikes(33996404L)
                        .build()
        );

        mockList.add(
                TrackSimpleDTO.builder()
                        .id(4L)
                        .name("My Blood")
                        .albumPosition(4)
                        .numberOfLikes(83328040L)
                        .build()
        );
        return mockList;
    }

}
