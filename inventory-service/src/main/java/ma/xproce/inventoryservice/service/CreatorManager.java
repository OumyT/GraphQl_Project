package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dtos.CreatorDto;

public interface CreatorManager {
public CreatorDto getCreatorById(Long id);
public CreatorDto saveCreator(CreatorDto creatorDto);
}
