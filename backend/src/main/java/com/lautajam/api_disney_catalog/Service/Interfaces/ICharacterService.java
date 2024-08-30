
package com.lautajam.api_disney_catalog.Service.Interfaces;

import java.util.List;
import com.lautajam.api_disney_catalog.Model.Character;
public interface ICharacterService {
    
    /**
     * Returns a list of all Characters in the database.
     * @return A list of all characters in the database
     */
    public List<Character> getAllCharacters();
    
    /**
     * Saves a character to the database
     * @param character The character to be saved
     */
    public void saveCharacter(Character character);
    
    /**
     * Deletes a character with the given id.
     * @param characterId The id of the character to be deleted
     */
    public void deleteCharacter(Long characterId);
    
    /**
     * Updates a character with the give a character.
     * @param character The character to be updated
     */
    public void editCharacter (Character character);
    
}
