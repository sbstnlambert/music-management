package be.technifutur.musicManagement.business.service.implementation;

import be.technifutur.musicManagement.business.service.specification.TrackService;
import be.technifutur.musicManagement.model.dto.TrackSimpleDTO;

import java.util.ArrayList;
import java.util.List;

public class TrackServiceMock implements TrackService {
    @Override
    public List<TrackSimpleDTO> getTracksByAlbum(Long albumId) {
        List<TrackSimpleDTO> mockList = new ArrayList<>();
        mockList.add(
                TrackSimpleDTO.builder()
                        .id(1L)
                        .name("Jumpsuit")
                        .numberOfLikes(116452548)
                        .build()
        );

        mockList.add(
                TrackSimpleDTO.builder()
                        .id(2L)
                        .name("Levitate")
                        .numberOfLikes(38584678)
                        .build()
        );

        mockList.add(
                TrackSimpleDTO.builder()
                        .id(3L)
                        .name("Morph")
                        .numberOfLikes(33996404)
                        .build()
        );

        mockList.add(
                TrackSimpleDTO.builder()
                        .id(4L)
                        .name("My Blood")
                        .numberOfLikes(83328040)
                        .build()
        );
        return mockList;
    }
}
