package com.evpowerguard.registration.repository;

import java.util.Optional;

import com.evpowerguard.registration.domain.Bookmark;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Spring Data SQL repository for the Registration entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Page<Bookmark> findByUserId(String userId, Pageable pageable);
}
