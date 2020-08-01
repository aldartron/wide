package co.wide.core.resource;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
interface ResourceMapper {

    @Mapping(target = "cardId", source = "card.id")
    Resource fromEntity(ResourceEntity entity);

    ResourceEntity toEntity(Resource resource);

}
