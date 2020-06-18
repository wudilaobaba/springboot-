package v3;

import v3.hero.Camille;
import v3.hero.Dinana;
import v3.hero.Irelia;

public class HeroFactory {
    public static ISkill getHero(String name){
        ISkill iSkill;
        switch (name){
            case "Dinana":
                iSkill = new Dinana();
                break;
            case "Irelia":
                iSkill = new Irelia();
                break;
            case "Camille":
                iSkill = new Camille();
                break;
            default:
                iSkill = null;
        }
        return iSkill;
    }
}
