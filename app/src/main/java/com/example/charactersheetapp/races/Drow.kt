package races

import com.example.charactersheetapp.Tav;
class Drow : Race {
    override fun RaceStatus(tav: Tav) {
        tav.raceName = "Drow"
        tav.speed = 9.0f;
        tav.nightVision = 18;
        tav.dexterity.value += 1;
        tav.intelligence.value += 1;
    }
}