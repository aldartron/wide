package co.wide.core.plan;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlanMapper {

    Plan fromEntity(PlanEntity planEntity);

    PlanEntity toEntity(Plan plan);

    List<Plan> fromEntities(List<Plan> planList);

    List<PlanEntity> toEntities(List<Plan> plans);

}
