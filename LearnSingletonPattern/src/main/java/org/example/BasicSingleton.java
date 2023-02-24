package org.example;

import java.io.Serializable;

public class BasicSingleton implements Serializable {

    private BasicSingleton() {
    }

    private static BasicSingleton INSTANCE;

    //    using synchronised deals with the potential  race condition as it blocks the next thread's call to method getInstance()
//    as long as the previous thread's execution is not finished
    public static synchronized BasicSingleton getInstance() {

//        LazyInitilisations has the potenital to cause race Conditons if there are two threads access this methods
        if (INSTANCE == null) {
            INSTANCE = new BasicSingleton();
        }
        return INSTANCE;
    }


//Double Checked locking to make it thread safe

    public static synchronized BasicSingleton getInstanceDoubleCheckLocking() {

//        LazyInitilisations has the potenital to cause race Conditons if there are two threads access this methods
        if (INSTANCE == null) {
            synchronized (BasicSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BasicSingleton();
                }
            }
        }
        return INSTANCE;
    }

    private int Value = 0;


    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }

    //    Fixing the serilization problem
    protected Object readResolve() {
        return INSTANCE;
    }

}
