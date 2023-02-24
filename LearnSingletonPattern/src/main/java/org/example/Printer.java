package org.example;

import java.util.HashMap;

public class Printer {


    private static int instanceCounter = 0;
    private Printer(){
        instanceCounter++;
        System.out.println("total instances of printer " + instanceCounter);

    }

    private static HashMap<Subsytem, Printer> printerInstances = new HashMap<>();

    public static Printer getPrinter(Subsytem SS) {

//        LazyLoad
        if (printerInstances.containsKey(SS)) {
            return printerInstances.get(SS);
        }

        Printer printer = new Printer();
        printerInstances.put(SS, printer);

        return printer;
    }


}
