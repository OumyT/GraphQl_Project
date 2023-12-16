package ma.xproce.inventoryservice.mapper;

import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dtos.VideoDto;
import ma.xproce.inventoryservice.dtos.VideoDtoInput;
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

    public VideoDto fromVideoToVideoDto(Video video) {
        return modelMapper.map(video, VideoDto.class);
    }

    public Video fromVideoDtoInputToVideo(VideoDtoInput videoDto) {
        return modelMapper.map(videoDto, Video.class);
    }

}
