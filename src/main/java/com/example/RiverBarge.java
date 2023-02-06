package com.example;

import lombok.extern.slf4j.Slf4j;

/**
 * \* Created with WXD.
 * \* Date:  2023/2/6
 * \* Description: 驳船
 * \* @author 王祥栋
 */
@Slf4j
public class RiverBarge extends Vehicle{
    @Override
    public double calcFuelEfficiency() {
        log.info("驳船的...........");
        return 0;
    }

    @Override
    public double calcTripDistance() {
        log.info("驳船的............");
        return 0;
    }

    public static void main(String[] args) {
        Vehicle vehicle =new RiverBarge();
        double v = vehicle.calcFuelEfficiency();

    }
}
