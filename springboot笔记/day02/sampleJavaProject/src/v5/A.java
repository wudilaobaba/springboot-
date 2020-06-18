package v5;

public class A implements Letter{
    private Letter letter;
    public A(Letter letter){
        this.letter = letter;
    }

    public A(){}

    public void setLetter(Letter letter) {
        this.letter = letter;
    }

    @Override
    public void saySelf() {
        letter.saySelf();
        System.out.println("I'm A");
    }
}
