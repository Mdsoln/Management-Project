package com.muddy.databaserelation.Repository;

import com.muddy.databaserelation.Entity.CourseMaterials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepo extends JpaRepository<CourseMaterials,Long> {

}
