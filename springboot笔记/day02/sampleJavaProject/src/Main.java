import v2.hero.Camille;
import v2.hero.Dinana;
import v4.ISkill;
import v2.hero.Irelia;
import v4.HeroFactory;
import v5.*;

import java.util.Scanner;

public class Main {
    private A a;
    /**
     * v1版本
     * @param args
     */
//    public static void main(String[] args) {
//        String name = getPlayerInput();
//        switch (name){
//            case "Dinana":
//                Dinana dinana = new Dinana();
//                dinana.r();
//                break;
//            case "Irelia":
//                Irelia irelia = new Irelia();
//                irelia.r();
//                break;
//            case "Camille":
//                Camille camille = new Camille();
//                camille.r();
//                break;
//        }
//    }
    /**
     * v2版本
     * @param args
     */
//    public static void main(String[] args) throws Exception {
//        String name = getPlayerInput();
//        ISkill iSkill;
//        switch (name){
//            case "Dinana":
//                iSkill = (ISkill) new Dinana();
//                break;
//            case "Irelia":
//                iSkill = (ISkill) new Irelia();
//                break;
//            case "Camille":
//                iSkill = (ISkill) new Camille();
//                break;
//            default:
//                throw new Exception("123456");
//        }
//        iSkill.r();
//    }

    /**
     * v3版本 写一个工厂类，专门new实例,但也仅仅是main方法实现了OCP
     * @param args
     */
//    public static void main(String[] args) {
//        String name = getPlayerInput();
//        ISkill iSkill = HeroFactory.getHero(name);
//        iSkill.r();
//    }

    /**
     * v4版本 使用反射
     * @param args
     */
//    public static void main(String[] args) {
//        String name = getPlayerInput();
//        ISkill iSkill = null;
//        try {
//            iSkill = HeroFactory.getHero(name);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        iSkill.r();
//    }

    /**
     * v5版本
     * @param args
     */
    public static void main(String[] args) {
        //启动控制器
        Container container = new Container();

        //由控制器实例化A
        Letter a = container.getBean2();
        a.saySelf();
    }

    private static String getPlayerInput(){
        System.out.println("Please enter a hero's name：");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
