package v5;

public class Container {
    //模拟控制器：以下仅针对A中依赖Letter类的情况
    public Letter getBean(){
        //构造注入
        Letter letter = new C();
        A a = new A(letter);
        return a;
    }


    public Letter getBean2(){
        //属性注入
        Letter letter = new C();
        A a = new A();
        a.setLetter(letter);
        return a;
    }
}
