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
    public float countWaterAmount(int age, int weight) {
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
     * Method adds entered value of drank water to currentValue
     */
    public void addDrankWater(float addWaterAmount) {
        if (addWaterAmount < 6000) {
            this.drankWater = this.drankWater + addWaterAmount;
        } else {
            warning = true;
        }
    }

    /**
     * Returns how much water has been drunk
     * @return reference to currentValue after adding drunk water amount
     */
    public float getDrankWaterValue() {
        if (warning == false) {
            return this.drankWater;
        } else {
            return -1;
        }
    }


    /**
     * resets currentValue to zero
     */
    public void reset() {
        this.drankWater = 0;
    }



}
