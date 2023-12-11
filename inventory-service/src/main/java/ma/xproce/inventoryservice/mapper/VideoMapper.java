package ma.xproce.inventoryservice.mapper;

import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dtos.VideoRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public VideoMapper(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

    public VideoRequest fromVideoToVideoRequest(Video video) {
        return modelMapper.map(video, VideoRequest.class);
    }

    public Video fromVideoRequestToVideo(VideoRequest videoRequest) {
        return modelMapper.map(videoRequest, Video.class);
    }

}
