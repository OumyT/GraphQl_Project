package ma.xproce.inventoryservice.mapper;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dtos.CreatorRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CreatorMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public CreatorMapper(ModelMapper modelMapper ){
        this.modelMapper = modelMapper;
    }

    public CreatorRequest fromCreatorToCreatorRequest(Creator creator){

        return modelMapper.map(creator, CreatorRequest.class);
    }

    public Creator fromCreatorRequestToCreator(CreatorRequest creatorRequest){

        return modelMapper.map(creatorRequest, Creator.class);
    }
}
