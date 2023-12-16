package ma.xproce.inventoryservice.web;

import ma.xproce.inventoryservice.dtos.CreatorDto;
import ma.xproce.inventoryservice.dtos.CreatorDtoInput;
import ma.xproce.inventoryservice.service.CreatorManagerFirstImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CreatorGraphQlController {
    @Autowired
    private CreatorManagerFirstImplementation creatorManager;

    @QueryMapping
    public CreatorDto getByID(@Argument Long id){return creatorManager.getByID(id);}
    @MutationMapping
    public CreatorDto saveCreator(@Argument CreatorDtoInput creatorDtoInput){
        return creatorManager.saveCreator(creatorDtoInput);

    }
}

