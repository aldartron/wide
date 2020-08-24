package co.wide.core.card.relation;

import co.wide.core.card.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRelationRepository extends JpaRepository<CardRelationEntity, Long> {

    List<CardRelationEntity> findByLeftOrRightOrderById(CardEntity left, CardEntity right);
}
