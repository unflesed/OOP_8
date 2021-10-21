package practise.task_2;

public class MyException extends  Exception{
    public MyException(String message){
        super(message);
    }
}

class Animal {
    private boolean collar;
    private boolean leash;
    public boolean isCollar() throws MyException {
        return collar;
    }
    public void setCollar(boolean collar) {
        this.collar = collar;
    }
    public boolean isLeash() throws MyException {
        return leash;
    }
    public void setLeash(boolean leash) {
        this.leash = leash;
    }
    void walking(){
        System.out.println("Выгул");
    }
}
class Main{
    public static void main(String[] args) {
        Animal dog = new Animal();
        try{
            if (!dog.isCollar())
            throw new MyException("Не вся экипировка");
            if (!dog.isLeash())
                throw new MyException("Не вся экипировка");
            dog.walking();
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
    }
}
