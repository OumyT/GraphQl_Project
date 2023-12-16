package ma.xproce.inventoryservice.web;

import ma.xproce.inventoryservice.dtos.VideoDto;
import ma.xproce.inventoryservice.dtos.VideoDtoInput;
import ma.xproce.inventoryservice.service.VideoManagerFirstImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class VideoGraphQlController {
    @Autowired
    private VideoManagerFirstImplementation videoManager;

    @QueryMapping
    public VideoDto getByID(@Argument Long id){return videoManager.getByID(id);}
    @MutationMapping
    public VideoDto saveVideo(@Argument VideoDtoInput VideoDtoInput){
        return videoManager.saveVideo(VideoDtoInput);

    }

}
