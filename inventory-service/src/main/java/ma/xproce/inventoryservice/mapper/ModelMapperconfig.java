package ma.xproce.inventoryservice.mapper;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dtos.CreatorRequest;
import ma.xproce.inventoryservice.dtos.VideoRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
;

@Component
@Configuration
public class ModelMapperconfig {
    @Bean

    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

