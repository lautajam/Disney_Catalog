/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lautajam.api_disney_catalog.Service;

import com.lautajam.api_disney_catalog.Service.Interfaces.ICharacterService;
import java.util.List;
import com.lautajam.api_disney_catalog.Model.Character;
import com.lautajam.api_disney_catalog.Model.Production;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lautajam.api_disney_catalog.Repository.ICharacterRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CharacterService implements ICharacterService{
    
    /**
     * The character repository to be injected. This repository provides access to the database.
     * This repository is used for tasks such as creating, updating, and retrieving character
     * information from the database.
     */
    @Autowired
    private ICharacterRepository characterRepository;

    /**
     * Returns a list of all Characters in the database.
     * @return A list of all characters in the database
     */
    @Override
    public List<Character> getAllCharacters() {
        List<Character> allCharactersList = characterRepository.findAll();
        return allCharactersList;
    }
    
    /**
     * Saves a character to the database
     * @param character The character to be saved
     */
    @Override
    public void saveCharacter(Character character) {
        characterRepository.save(character);
    }

    /**
     * Deletes a character with the given id.
     * @param characterId The id of the character to be deleted
     */
    @Override
    public void deleteCharacter(Long characterId) {
        characterRepository.deleteById(characterId);
    }
    
    /**
     * Updates a character with the give a area.
     * @param character The area to be updated
     */
    @Override
    public void editCharacter(Character character) {
        if (character.getCharacterId() != null && characterRepository.existsById(character.getCharacterId())) {
            // Retrieve the existing character from the database
            Character existingCharacter = characterRepository.findById(character.getCharacterId())
                    .orElseThrow(() -> new EntityNotFoundException("Character not found for update"));

            // Update fields
            updateCharacterFields(existingCharacter, character);

            // Update productions
            updateCharacterProductions(existingCharacter, character);

            // Save the updated character in the database
            characterRepository.save(existingCharacter);
        } else {
            throw new EntityNotFoundException("Character not found for update");
        }
    }

    // Update only the fields that were provided 
    private void updateCharacterFields(Character existingCharacter, Character character) {
        existingCharacter.setCharName(character.getCharName() != null ? character.getCharName() : existingCharacter.getCharName());
        existingCharacter.setAge(character.getAge() > 0 ? character.getAge() : existingCharacter.getAge());
        existingCharacter.setWeight(character.getWeight() > 0 ? character.getWeight() : existingCharacter.getWeight());
        existingCharacter.setHistory(character.getHistory() != null ? character.getHistory() : existingCharacter.getHistory());
        existingCharacter.setImage(character.getImage() != null ? character.getImage() : existingCharacter.getImage());
    }
    
    // Handle production if provided
    private void updateCharacterProductions(Character existingCharacter, Character character) {
        if (character.getProductions() != null && !character.getProductions().isEmpty()) {
            for (Production production : character.getProductions()) {
                if (!existingCharacter.getProductions().contains(production)) {
                    existingCharacter.getProductions().add(production);
                }
            }
        }
    }

      
}
