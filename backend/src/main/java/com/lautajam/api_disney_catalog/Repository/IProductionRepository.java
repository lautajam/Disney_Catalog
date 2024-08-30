package com.lautajam.api_disney_catalog.Repository;

import com.lautajam.api_disney_catalog.Model.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductionRepository extends JpaRepository<Production, Long> {

}
