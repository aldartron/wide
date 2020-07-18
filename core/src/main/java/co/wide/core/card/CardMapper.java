package co.wide.core.card;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CardMapper {

    Card fromEntity(CardEntity entity);

    CardEntity toEntity(Card card);

}
