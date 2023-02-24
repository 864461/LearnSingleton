package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        Basic Singleton
        BasicSingleton test = BasicSingleton.getInstance();
        test.setValue(45454);
        System.out.println(test.getValue());


        //Breaking singleton through Serilization

        String fileName = "BasicSIngleton.bin";
        saveToFile(test,fileName);
        test.setValue(9939328);
        BasicSingleton test2 = readFromFile(fileName);

        System.out.println("orginalInstance should be 9939328 " + test.getValue() );
        System.out.println("orginalInstance should be 9939328 " + test2.getValue() );


//Example of static singleton
        InnerStaticSingleton.Impl nested = new InnerStaticSingleton.Impl();
        InnerStaticSingleton innerSingleTon = nested.getINSTANCE();


//        enum based signleton

        String secondFileName = "secondbinFile";
        EnumBasedSingleton singleton = EnumBasedSingleton.INSTANCE;
        singleton.setValue(888);
        saveToFile(singleton,secondFileName);
//        singleton.setValue(999);

        EnumBasedSingleton singletonTest = readFromFileEnum(secondFileName);

        System.out.println("First Singleton" + singleton.getValue());
        System.out.println("Second Singleton " + singletonTest.getValue());


//        Monostate singleton
        MonoStateChefOfficer officer = new MonoStateChefOfficer();
        officer.setName("alvin");
        officer.setAge(56);


        MonoStateChefOfficer officer1 = new MonoStateChefOfficer();
        System.out.println("officer One " + officer.toString());
//        when you make a new class on monostateChefOffice there is no indication/communication to user that the class in already has values
        System.out.println("officer two " + officer1.toString());

        officer1.setName("calvin");
        officer1.setAge(20);

        System.out.println("officer One " + officer.toString());
        System.out.println("officer two " + officer1.toString());



        //MultitonExample Controlled createtion of multiple Singleton objects
        Printer primaryPrinter = Printer.getPrinter(Subsytem.PRIMARY);
        Printer secondaryPrinter = Printer.getPrinter(Subsytem.SECONDARY);
        Printer FallBackPrinter = Printer.getPrinter(Subsytem.FALLBACK);

//        trying to create multiple instance of primary printer only retrun  same instance due to lazyLoad singleton
        Printer primaryPrinter2 = Printer.getPrinter(Subsytem.PRIMARY);
        Printer secondaryPrinter2 = Printer.getPrinter(Subsytem.SECONDARY);
        Printer FallBackPrinter2 = Printer.getPrinter(Subsytem.FALLBACK);

    }


    static void saveToFile(BasicSingleton singleton,String fileName) throws Exception {
        try(FileOutputStream fileOut = new FileOutputStream(fileName); ObjectOutputStream out = new ObjectOutputStream(fileOut)){
            out.writeObject(singleton);
        }
    }
    static void saveToFile(EnumBasedSingleton singleton,String fileName) throws Exception {
        try(FileOutputStream fileOut = new FileOutputStream(fileName); ObjectOutputStream out = new ObjectOutputStream(fileOut)){
            out.writeObject(singleton);
        }
    }

    static BasicSingleton readFromFile(String fileName) throws Exception {
        try(FileInputStream fileIn = new FileInputStream(fileName); ObjectInputStream in = new ObjectInputStream(fileIn)){
            return (BasicSingleton) in.readObject();
        }

    }

    static EnumBasedSingleton readFromFileEnum(String fileName) throws Exception {
        try(FileInputStream fileIn = new FileInputStream(fileName); ObjectInputStream in = new ObjectInputStream(fileIn)){
            return (EnumBasedSingleton) in.readObject();
        }

    }

}