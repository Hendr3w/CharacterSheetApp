package races

import com.example.charactersheetapp.Tav

class Elf : Race{
    override fun RaceStatus(tav: Tav) {
        tav.raceName = "Elfo"
        tav.dexterity.value += 2;
        tav.intelligence.value += 2;
        tav.speed = 9f;
        tav.nightVision = 18;


        //Implement Perception Proficiency
        //Implement Meditation
        //Implement Incantation Resistance

        
    }
}