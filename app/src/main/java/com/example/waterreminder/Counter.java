package com.example.waterreminder;


/**
 * This class counts the amount of water that user should drink daily.
 * @author Ida
 */

public class Counter {
    private float waterAmount;
    private float drankWater;

    public Counter() {
        this.drankWater = 0;
    }

    /**
     * Counts the amount of water that should be drank daily
     * @return reference to waterAmount
     */
    public float countWaterAmount(int age , int weight) {
        waterAmount = (age * weight) / 1000.0f;
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
     * Method adds entered amount of drank water to drankWater variable
     */
    public void addDrankWater(float addWaterAmount) {
        this.drankWater = this.drankWater + addWaterAmount;

    }

    /**
     * Returns how much water has been drunk
     * @return reference to drankWater after adding drunk water amount
     */
    public float getDrankWaterValue() {
        return this.drankWater;
    }


    /**
     * resets drankWater value to zero
     */
    public void reset() {
        this.drankWater = 0;
    }

    /**
     * resets estimated water consumption value to zero
     */
    public void resetSettings() {
        this.waterAmount = 0;
    }

}
