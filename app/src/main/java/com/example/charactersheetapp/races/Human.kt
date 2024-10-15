package races
import com.example.charactersheetapp.Tav

class Human : Race {
    override fun RaceStatus(tav : Tav) {
        tav.raceName = "Humano"
        tav.nightVision = 0;
        tav.speed = 9F;
        tav.strength.value += 1;
        tav.dexterity.value += 1;
        tav.constituition.value += 1;
        tav.intelligence.value += 1
        tav.wisdom.value += 1;
        tav.charisma.value += 1;

        //Choose one proficiency

    }

}