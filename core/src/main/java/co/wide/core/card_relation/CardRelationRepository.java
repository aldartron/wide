package co.wide.core.card_relation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRelationRepository extends JpaRepository<CardRelationEntity, Long> {
}
