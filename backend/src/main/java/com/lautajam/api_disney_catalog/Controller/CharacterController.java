/*
CRUD
/characters       | display picture and name of all characters (now show all FIX)
/character/create | create
/character/delete | delete
/character/update | update

READ filters
/character/detail/{id}        | details of a character
GET/character?name=name       | search for character by name
GET/character?age=age         | search character by age
GET/character?movies=idMovies | search character by movies
*/

package com.lautajam.api_disney_catalog.Controller;

import com.lautajam.api_disney_catalog.Service.CharacterService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.lautajam.api_disney_catalog.Model.Character;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/disney-catalog/")
public class CharacterController {
    
    /**
     * The characters service to be injected. This service provides access to the database
     * for retrieving and managing characters-related data.
     * This service is used for tasks such as creating, updating, and retrieving characters
     * information from the database.
     */
    @Autowired
    private CharacterService characterServ;
    
    /**
     * Retrieves a list of all characters in the system.
     *
     * @return ResponseEntity with the list of characters and the status of the operation:
     *         - HttpStatus.OK (200) if the list of characters is successfully retrieved.
     *         - HttpStatus.NO_CONTENT (204) if no characters are found.
     */
    @GetMapping("/characters")
    @ResponseBody
    public ResponseEntity<List<Character>> getAllCharacters(){
        List<Character> allCharacterList = new ArrayList<>();
        
        try{
            allCharacterList = characterServ.getAllCharacters();
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(!allCharacterList.isEmpty())
            return new ResponseEntity<>(allCharacterList, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
        
    @PostMapping("/characters/create")
    public ResponseEntity<Character> createCharacter(@RequestBody Character newCharacter) {
        try{
            characterServ.saveCharacter(newCharacter);
            return new ResponseEntity<>(newCharacter, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 
}
