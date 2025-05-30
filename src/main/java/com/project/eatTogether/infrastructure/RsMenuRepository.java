package com.project.eatTogether.infrastructure;

import com.project.eatTogether.domain.entity.RsMenus;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RsMenuRepository extends JpaRepository<RsMenus, Long> {
  @Query("SELECT m FROM RsMenus m WHERE m.rsRestaurant.rsId = :rsId AND m.rsMenuAppear <> 'N' AND m.deletedAt IS NULL ")
  Page<RsMenus> findByRsRestaurantRsId(Long rsId, Pageable pageable);

  RsMenus findByRsRestaurantRsId(Long rsId);

  @Query("SELECT m FROM RsMenus m WHERE m.rsRestaurant.rsId = :rsId AND m.rsMenuAppear <> 'N' AND m.deletedAt IS NULL ")
  List<RsMenus> findByRsId(Long rsId);
}
