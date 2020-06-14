package co.wide.core.card;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {

    Card fromEntity(CardEntity entity);

    CardEntity toEntity(Card card);
}
