package com.example.waterreminder;

/**
 * This class counts the amount of water that user should drink daily.
 * @author ida
 * @version 1.0
 */

public class Counter {
    private UserData user;
    private float waterAmount;
    private float drankWater;
    private float currentValue;

    public Counter() {
        this.user = user;
        //this.waterAmount = countWaterAmount();
        this.drankWater = 0;
        this.currentValue = 0;
    }

    /**
     * Counts the amount of water that should be drank daily
     * @return reference to waterAmount
     */
    private Float countWaterAmount() {
        waterAmount = (this.user.getAge() * this.user.getWeight()) / 1000;
        return waterAmount;
    }

    /**
     * Returns counted amount of water that should be drank daily
     * @return reference to waterAmount after calculating
     */
    public float getWaterAmount() {
        return this.waterAmount;
    }

    /**
     * Method adds entered value of drank water to currentValue
     */
    public void addDrankWater() {
        this.currentValue = this.currentValue + this.drankWater;
    }

    /**
     * Returns how much water has been drunk
     * @return reference to currentValue after adding drunk water amount
     */
    public Float getDrankWaterValue() {
        return currentValue;
    }

    /**
     * resets currentValue to zero
     */
    public void reset() {
        this.currentValue = 0;
    }
}
