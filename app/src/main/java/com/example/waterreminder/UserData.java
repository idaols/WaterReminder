package com.example.waterreminder;

/**
 * This class contains information of the user.
 * @author ida
 * @version 1.0
 */

public class UserData {
    private String name;
    private int age;
    private float weight;

    public UserData() {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    /**
     * Returns given name
     * @return reference to name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns given age
     * @return reference to age
     */

    public int getAge() { return age;}

    /**
     * Returns given weight
     * @return reference to weight
     */

    public float getWeight() {
        return weight;
    }
}
