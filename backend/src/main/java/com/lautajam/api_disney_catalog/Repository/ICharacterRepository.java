package com.lautajam.api_disney_catalog.Repository;

import com.lautajam.api_disney_catalog.Model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterRepository extends JpaRepository<Character, Long> {
}
