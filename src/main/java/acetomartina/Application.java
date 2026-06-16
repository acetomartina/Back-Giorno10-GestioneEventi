package acetomartina;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    public static final EntityManagerFactory app = Persistence.createEntityManagerFactory("GestioneEventi");

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

