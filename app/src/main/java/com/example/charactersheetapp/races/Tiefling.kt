package races

import com.example.charactersheetapp.Tav;

class Tiefling : Race{

    override fun RaceStatus(tav: Tav) {
        tav.raceName = "Tiefling"
        tav.speed = 9f;
        tav.nightVision = 18;
        tav.charisma.value += 2;
        tav.intelligence.value += 1;

        //Implement Fire Resistance
        //Implement Infernal Magic
    }
}