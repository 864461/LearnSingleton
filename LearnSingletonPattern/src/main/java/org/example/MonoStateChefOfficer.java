package org.example;
// since the field are static MonostateChefOffice can be instatiated many different times but the field will map to the static value mean the value are singleton
public class MonoStateChefOfficer {

    private static  String name;
    private  static int age;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        MonoStateChefOfficer.name = name;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        MonoStateChefOfficer.age = age;
    }

    @Override
    public String toString() {
        return "MonoStateChefOfficer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
