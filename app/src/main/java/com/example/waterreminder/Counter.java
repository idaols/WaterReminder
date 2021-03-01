package com.example.waterreminder;

/**
 * This class counts the amount of water that user should drink daily.
 * @author ida
 * @version 1.0
 */

public class Counter {
    private UserData user;
    private float waterAmount;

    public Counter(UserData user) {
        this.user = user;
        this.waterAmount = countWaterAmount();
    }

    /**
     * Counts the amount of water that should be drank
     * @return reference to waterAmount
     */
    private float countWaterAmount() {
        waterAmount = (this.user.getAge() * this.user.getWeight()) / 1000;
        return waterAmount;
    }

    /**
     * Returns counted amount of water
     * @return reference to waterAmount after calculating
     */
    public float getWaterAmount() {
        return this.waterAmount;
    }
}
