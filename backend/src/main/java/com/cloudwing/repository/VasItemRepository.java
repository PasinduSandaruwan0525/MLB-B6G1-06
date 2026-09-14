package com.cloudwing.repository;

import com.cloudwing.entity.VasItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VasItemRepository extends JpaRepository<VasItem, Long> {
    Optional<VasItem> findByCode(String code);
    List<VasItem> findByActiveTrue();
}
