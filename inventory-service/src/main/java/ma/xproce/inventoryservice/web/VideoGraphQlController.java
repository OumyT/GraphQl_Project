package ma.xproce.inventoryservice.web;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import ma.xproce.inventoryservice.dtos.CreatorRequest;
import ma.xproce.inventoryservice.dtos.VideoRequest;
import ma.xproce.inventoryservice.mapper.CreatorMapper;
import ma.xproce.inventoryservice.mapper.ModelMapperconfig;
import ma.xproce.inventoryservice.mapper.VideoMapper;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

public class VideoGraphQlController {
    private CreatorRepository creatorRepository;
    private VideoRepository videoRepository;
    private CreatorMapper creatorMapper;
    private VideoMapper videoMapper;

    VideoGraphQlController(CreatorRepository creatorRepository, VideoRepository videoRepository, CreatorMapper creatorMapper, VideoMapper videoMapper){
        this.creatorRepository = creatorRepository;
        this.videoRepository = videoRepository;
        this.creatorMapper = creatorMapper;
        this.videoMapper = videoMapper;
    }

    @QueryMapping
    public List<VideoRequest> videoList() {
        List<Video> videos = videoRepository.findAll();
        return videos.stream()
                .map(videoMapper::fromVideoToVideoRequest)
                .collect(Collectors.toList());
    }

    @QueryMapping
    public CreatorRequest creatorById(@Argument Long id) {
        Creator creator = creatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Creator %s not found", id)));
        return creatorMapper.fromCreatorToCreatorRequest(creator);
    }


    @MutationMapping
    public Video saveVideo(@Argument VideoRequest videoRequest) {
        Video video = videoMapper.fromVideoRequestToVideo(videoRequest);
        return videoRepository.save(video);
    }

    @MutationMapping
    public CreatorRequest saveCreator(@Argument CreatorRequest creatorRequest){
        Creator creator = creatorMapper.fromCreatorRequestToCreator(creatorRequest);
        Creator savedCreator = creatorRepository.save(creator);
        return creatorMapper.fromCreatorToCreatorRequest(savedCreator);
    }

}