package co.wide.core.card.relation;

import co.wide.core.card.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRelationRepository extends JpaRepository<CardRelationEntity, Long> {

    @Query("from CardRelationEntity where (left = :card or right = :card) and type = :relationType")
    List<CardRelationEntity> findByLeftOrRightOfType(CardEntity card, CardRelationType relationType);

    @Query("from CardRelationEntity where left = :card and type = :relationType")
    List<CardRelationEntity> findByLeftOfType(CardEntity card, CardRelationType relationType);

}
