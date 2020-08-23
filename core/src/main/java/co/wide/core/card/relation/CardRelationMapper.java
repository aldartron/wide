package co.wide.core.card.relation;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CardRelationMapper {

    CardRelation fromEntity(CardRelationEntity entity);

    CardRelationEntity toEntity(CardRelation relation);
}
