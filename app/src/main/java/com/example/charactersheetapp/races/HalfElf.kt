package races

import com.example.charactersheetapp.Tav;

class HalfElf : Race{

    override fun RaceStatus(tav: Tav) {
        tav.raceName = "Meio-Elfo"
        tav.speed = 9f;
        tav.nightVision = 18;
        tav.charisma.value += 2;



        //Implement +1 on two attributes by choice
        //Implement 2 proficiencies by choice
        //Implement Incantation Resistance
    }
}