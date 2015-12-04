package com.bookmarkit.repository;

import com.bookmarkit.domain.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by 580782 on 11/29/2015.
 */

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Optional<Bookmark> findOneById(Long id);
}
