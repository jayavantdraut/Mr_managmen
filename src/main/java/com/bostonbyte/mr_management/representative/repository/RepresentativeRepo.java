package com.bostonbyte.mr_management.representative.repository;

import com.bostonbyte.mr_management.representative.entity.Representative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepresentativeRepo extends JpaRepository<Representative,Integer> {

}
