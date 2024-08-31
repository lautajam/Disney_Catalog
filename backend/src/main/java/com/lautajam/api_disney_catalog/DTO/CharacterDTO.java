
package com.lautajam.api_disney_catalog.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CharacterDTO {
    private String charDtoName;
    private String charDtoImage;

    public CharacterDTO(String charDtoName, String charDtoImage) {
        this.charDtoName = charDtoName;
        this.charDtoImage = charDtoImage;
    }
}
