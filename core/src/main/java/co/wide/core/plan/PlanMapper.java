package co.wide.core.plan;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface PlanMapper {

    Plan fromEntity(PlanEntity planEntity);

    PlanEntity toEntity(Plan plan);

    List<Plan> fromEntities(List<PlanEntity> planList);

    List<PlanEntity> toEntities(List<Plan> plans);

}
