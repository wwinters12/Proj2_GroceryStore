package main.user;

public abstract class AbstractUser {
    int id;
    
    public AbstractUser(int id){
        this.id = id;

    }

    public int getId(){
        return id;
    }

}