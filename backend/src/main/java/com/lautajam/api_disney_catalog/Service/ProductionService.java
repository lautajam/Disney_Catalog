/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lautajam.api_disney_catalog.Service;

import com.lautajam.api_disney_catalog.DTO.ProductionDTO;
import com.lautajam.api_disney_catalog.Model.Production;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lautajam.api_disney_catalog.Repository.IProductionRepository;
import com.lautajam.api_disney_catalog.Service.Interfaces.IProductionService;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import com.lautajam.api_disney_catalog.Model.Character;

@Service
public class ProductionService implements IProductionService {

    /**
     * The production repository to be injected. This repository provides access to the database. It is used for tasks such as
     * creating, updating, and retrieving production information from the database.
     */
    @Autowired
    private IProductionRepository productionRepository;

    /**
     * Returns a list of all Productions in the database. This method retrieves all productions from the database, converts them
     * into ProductionDTO objects, and returns them in a list.
     *
     * @return A list of all productions in the database.
     */
    @Override
    public List<ProductionDTO> getAllProductions() {
        List<ProductionDTO> allProductionsDtoList = new ArrayList<>();

        for (Production production : productionRepository.findAll()) {
            allProductionsDtoList.add(new ProductionDTO(production.getProductionId(), production.getTitle(), production.getImage(), production.getCrationDate()));
        }

        return allProductionsDtoList;
    }

    /**
     * Saves a production to the database. This method persists the given production object into the database by utilizing the
     * production repository. If the production already exists, it is updated; otherwise, a new production is created.
     *
     * @param production The production to be saved.
     */
    @Override
    public void saveProduction(Production production) {
        productionRepository.save(production);
    }

    /**
     * Deletes a production with the given id. This method removes a production from the database based on the provided
     * productionId. If no production with the specified id exists, nothing happens.
     *
     * @param productionId The id of the production to be deleted.
     */
    @Override
    public void deleteProduction(Long productionId) {
        productionRepository.deleteById(productionId);
    }

    /**
     * Updates a production with the given data.
     *
     * @param production The production to be updated.
     */
    @Override
    public void editProduction(Production production) {
        if (production.getProductionId() != null && productionRepository.existsById(production.getProductionId())) {
            // Retrieve the existing production from the database
            Production existingProduction = productionRepository.findById(production.getProductionId())
                    .orElseThrow(() -> new EntityNotFoundException("Production not found for update"));

            // Update fields
            updateProductionFields(existingProduction, production);

            // Update characters
            updateProductionCharacters(existingProduction, production);

            // Save the updated production in the database
            productionRepository.save(existingProduction);
        } else {
            throw new EntityNotFoundException("Production not found for update");
        }
    }

    /**
     * Updates the fields of an existing production with values from the provided production. This method will only update fields
     * that are non-null or valid in the provided production object.
     *
     * If a field in the provided production object is null or has an invalid value (e.g., non-positive score), the existing value
     * in the `existingProduction` object remains unchanged.
     *
     * @param existingProduction The production object to be updated.
     * @param production The production object containing new values to update.
     */
    private void updateProductionFields(Production existingProduction, Production production) {
        existingProduction.setTitle(production.getTitle() != null ? production.getTitle() : existingProduction.getTitle());
        existingProduction.setCrationDate(production.getCrationDate() != null ? production.getCrationDate() : existingProduction.getCrationDate());
        existingProduction.setScore(production.getScore() > 0 ? production.getScore() : existingProduction.getScore());
        existingProduction.setImage(production.getImage() != null ? production.getImage() : existingProduction.getImage());
    }

    /**
     * Updates the list of characters for an existing production by adding new characters from the provided production. This
     * method adds characters from the provided production to the existing production's character list, only if they are not
     * already present in the existing production's list.
     *
     * If the provided production's characters list is null or empty, no changes are made to the existing production's characters.
     *
     * @param existingProduction The production object whose characters are to be updated.
     * @param production The production object containing new characters to be added.
     */
    private void updateProductionCharacters(Production existingProduction, Production production) {
        if (production.getCharacters() != null && !production.getCharacters().isEmpty()) {
            for (Character character : production.getCharacters()) {
                if (!existingProduction.getCharacters().contains(character)) {
                    existingProduction.getCharacters().add(character);
                }
            }
        }
    }

}
