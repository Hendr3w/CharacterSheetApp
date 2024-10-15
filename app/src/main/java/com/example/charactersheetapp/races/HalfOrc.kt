package races

import com.example.charactersheetapp.Tav;

class HalfOrc : Race {

    override fun RaceStatus(tav: Tav) {
        tav.raceName = "Meio-Orc"
        tav.speed = 9f;
        tav.nightVision = 18;
        tav.strength.value += 2;
        tav.constituition.value += 1;

        //Implement Immortal Resistance
        //Implement Brutal Strength
    }
}