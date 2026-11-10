
package com.virtualstore;

import com.virtualstore.database.DatabaseInitializer;

public class Main {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("       VIRTUAL STORE");
        System.out.println("================================");

        System.out.println("Inicializando base de datos...");

        DatabaseInitializer.initialize();

        System.out.println("Proceso de inicializacion finalizado.");

        CrudDemo.run();
    }
}

