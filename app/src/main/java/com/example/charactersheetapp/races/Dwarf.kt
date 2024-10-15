package races
import com.example.charactersheetapp.Tav

class Dwarf : Race {

    override fun RaceStatus(tav: Tav) {
        tav.raceName = "Anão"
        tav.speed = 7.5f;
        tav.nightVision = 18;
        tav.constituition.value += 2;
        tav.wisdom.value += 1;

        //Implement poison resistance
        //Implement crafting tools proficiency
        //Implement Incantation Resistance

    }
}