package org.nhnnext.recover24.fantastic_summer_crawler.repository;

import org.nhnnext.recover24.fantastic_summer_crawler.domain.Comic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicRepository extends JpaRepository<Comic, Long> {

}