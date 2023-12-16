package ma.xproce.inventoryservice.mapper;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dtos.CreatorDto;
import ma.xproce.inventoryservice.dtos.CreatorDtoInput;
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

    public CreatorDto fromCreatorToCreatorDto(Creator creator){

        return modelMapper.map(creator, CreatorDto.class);
    }

    public Creator fromCreatorDtoInputToCreator(CreatorDtoInput creatorDto){

        return modelMapper.map(creatorDto, Creator.class);
    }
}
