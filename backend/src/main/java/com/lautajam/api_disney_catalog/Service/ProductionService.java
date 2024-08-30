/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lautajam.api_disney_catalog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lautajam.api_disney_catalog.Repository.IProductionRepository;

@Service
public class ProductionService {
    
    @Autowired
    private IProductionRepository productionRepository;
}
