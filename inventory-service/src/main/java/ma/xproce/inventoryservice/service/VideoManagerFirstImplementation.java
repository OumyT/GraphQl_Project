package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import ma.xproce.inventoryservice.dtos.VideoDto;
import ma.xproce.inventoryservice.dtos.VideoDtoInput;
import ma.xproce.inventoryservice.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VideoManagerFirstImplementation implements VideoManager {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private VideoMapper videoMappers;

    public VideoDto getByID(Long id) {
        return videoMappers.fromVideoToVideoDto(videoRepository.findById(id).get());
    }

    public VideoDto saveVideo(VideoDtoInput videoDtoInput) {
        Video video = videoMappers.fromVideoDtoInputToVideo(videoDtoInput);
        video = videoRepository.save(video);
        return videoMappers.fromVideoToVideoDto(video);
    }

    @Override
    public VideoDto getVideoById(Long id) {
        return null;
    }

    @Override
    public VideoDto saveVideo(VideoDto videoDto) {
        return null;
    }
}
