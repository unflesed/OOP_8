package practise.task_2;

public class MyException extends  Exception{
    public MyException(String message){
        super(message);
    }
}
class Animal {
    private boolean collar;
    private boolean leash;
    public Animal(boolean collar, boolean leash){
        this.collar = collar;
        this.leash = leash;
    }
    boolean isCollar(){
        return collar;
    }
    boolean isLeash(){
        return leash;
    }
    void walking() throws MyException {
        if (isLeash() && isCollar())
            System.out.println("Выгул");
        else
            throw new MyException("Не вся экипировка");
    }
}
class Main{
    public static void main(String[] args) {
        Animal dog = new Animal(true, false);
        try {
            dog.walking();
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
    }
}
