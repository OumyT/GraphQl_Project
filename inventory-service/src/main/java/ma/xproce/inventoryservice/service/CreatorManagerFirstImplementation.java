package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import ma.xproce.inventoryservice.dtos.CreatorDto;
import ma.xproce.inventoryservice.dtos.CreatorDtoInput;
import ma.xproce.inventoryservice.mapper.CreatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatorManagerFirstImplementation implements CreatorManager{
    @Autowired
    private CreatorRepository creatorRepository;
    @Autowired
    private CreatorMapper creatorMappers;

    public CreatorDto getByID(Long id) {
        return creatorMappers.fromCreatorToCreatorDto(creatorRepository.findById(id).get());
    }

    public CreatorDto saveCreator(CreatorDtoInput creatorDtoInput) {
        Creator creator = creatorMappers.fromCreatorDtoInputToCreator(creatorDtoInput);
        creator = creatorRepository.save(creator);
        return creatorMappers.fromCreatorToCreatorDto(creator);
    }

    @Override
    public CreatorDto getCreatorById(Long id) {
        return null;
    }

    @Override
    public CreatorDto saveCreator(CreatorDto creatorDto) {
        return null;
    }
}
