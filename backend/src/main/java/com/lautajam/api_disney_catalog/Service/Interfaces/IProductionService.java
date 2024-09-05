
package com.lautajam.api_disney_catalog.Service.Interfaces;

import com.lautajam.api_disney_catalog.DTO.ProductionDTO;
import java.util.List;
import com.lautajam.api_disney_catalog.Model.Production;

public interface IProductionService {
     
    /**
     * Returns a list of all Productions in the database.
     * @return A list of all Productions in the database
     */
    public List<ProductionDTO> getAllProductions();
    
    /**
     * Saves a production to the database
     * @param production The production to be saved
     */
    public void saveProduction(Production production);
    
    /**
     * Deletes a production with the given id.
     * @param productionId The id of the production to be deleted
     */
    public void deleteProduction(Long productionId);
    
    /**
     * Updates a production with the give a production.
     * @param production The production to be updated
     */
    public void editProduction(Production production);
}
