package org.example.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AppEntityManagerFactory {
    private static EntityManagerFactory emf;
    private AppEntityManagerFactory(){}

    static {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public static EntityManagerFactory getEMF(){
        return emf;
    }
}
