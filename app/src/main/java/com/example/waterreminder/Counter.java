package com.example.waterreminder;

import android.widget.TextView;

/**
 * This class counts the amount of water that user should drink daily.
 * @author ida
 * @version 1.0
 */

public class Counter {
    private float waterAmount;
    private float drankWater;
    private boolean warning;

    public Counter() {
        //this.waterAmount = countWaterAmount();
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
     * If user adds value of 6000 or more, counter sends a warning message
     */
    public void addDrankWater(float addWaterAmount) {
        this.drankWater = this.drankWater + addWaterAmount;

    }

    /**
     * Returns how much water has been drunk
     * If user adds value of 6000 or more, counter returns -1 and a warning message appears
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


    public void resetSettings() {
        this.waterAmount = 0;
    }

}
