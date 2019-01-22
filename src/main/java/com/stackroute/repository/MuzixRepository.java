/**
 * A Repository interface that extends JpaRepository with type Muzix and primary key of type Integer
 */
package com.stackroute.repository;

import com.stackroute.domain.Muzix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuzixRepository extends JpaRepository<Muzix,Integer> {
}
