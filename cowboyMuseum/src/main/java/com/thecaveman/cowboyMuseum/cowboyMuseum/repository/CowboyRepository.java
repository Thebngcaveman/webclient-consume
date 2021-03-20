package com.thecaveman.cowboyMuseum.cowboyMuseum.repository;

import com.thecaveman.cowboyMuseum.cowboyMuseum.model.Cowboy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CowboyRepository extends JpaRepository<Cowboy,Long> {
}
