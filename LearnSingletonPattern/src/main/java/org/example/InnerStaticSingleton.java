package org.example;

public class InnerStaticSingleton {
    private InnerStaticSingleton(){}


    public static class Impl{
        private static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();


        public static InnerStaticSingleton getINSTANCE() {
            return Impl.INSTANCE;
        }
    }
}

//    It uses the static keyword to ensure that only one instance of the class is created and shared across all threads.
//        It uses a private constructor to prevent other classes from creating new instances of the class.
//        It ensures that the single instance of the class is created only once, preventing race conditions and synchronization issues.

//    The inner static singleton pattern ensures thread safety in Java by making
//        use of the static keyword, which ensures that only one instance of the class is created and
//        shared across all threads. When a class is declared as static, its fields and methods are shared
//        across all instances of the class, ensuring that all threads have access to the same instance of the singleton.