package co.wide.core.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {

    @Query("from ResourceEntity r where r.card.id = :cardId")
    List<ResourceEntity> findByCardId(Long cardId);

}
