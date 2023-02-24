package org.example;

 enum EnumBasedSingleton {

     INSTANCE;

     EnumBasedSingleton(){
         value = 45;
     }
     private int value;

     public int getValue() {
         return value;
     }

     public void setValue(int value) {
         this.value = value;
     }
 }
