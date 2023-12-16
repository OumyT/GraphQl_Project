package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dtos.VideoDto;

public interface VideoManager {
    public VideoDto getVideoById(Long id);
    public VideoDto saveVideo(VideoDto videoDto);
}
