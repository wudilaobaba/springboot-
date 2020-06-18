package v4;

public class HeroFactory {
    public static ISkill getHero(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //反射
        Class cla = Class.forName("v4.hero."+name);
        Object obj = cla.newInstance();
        return (ISkill)obj;
    }
}



