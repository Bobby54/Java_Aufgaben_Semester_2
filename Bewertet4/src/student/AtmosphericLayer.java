package student;

import java.util.Locale;

public enum AtmosphericLayer {

    TROPO("Troposphäre", "Troposphere", 0),
    STRATO("Stratosphäre", "Stratosphere", 15000),
    MESO("Mesosphäre", "Mesosphere", 50000),
    THERMO("Thermosphäre", "Thermosphere", 80000),
    EXO("Exosphäre", "Exosphere", 500000);

    public String german, english;
    Length startAltitude;


    AtmosphericLayer(String german, String english, int sAltitude){
        this.german = german;
        this.english = english;
        startAltitude = new Length(LengthUnit.METER, sAltitude);
    }

    public Length getStartAltitude(){
        return startAltitude;
    }

    public String getGerman(){
        return german;
    }

    public String getEnglish(){
        return english;
    }


    @Override
    public String toString(){
        return getGerman() + " über " + startAltitude.toString();
    }
}
