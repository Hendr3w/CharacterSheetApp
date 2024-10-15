package races

import com.example.charactersheetapp.Tav
class Halfling : Race {
    override fun RaceStatus(tav: Tav) {
        tav.raceName = "Halfling"
        tav.speed = 7.5f;
        tav.nightVision = 0;
        tav.dexterity.value += 2;
        tav.charisma.value += 1;

        //Implement halfling luck
        //Implement halfling agility
        //Implement Natural Concealment

    }
}