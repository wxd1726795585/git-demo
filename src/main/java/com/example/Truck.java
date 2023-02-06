package com.example;

import lombok.extern.slf4j.Slf4j;

/**
 * \* Created with WXD.
 * \* Date:  2023/2/6
 * \* Description: 卡车的
 * \* @author 王祥栋
 */
@Slf4j
public class Truck extends Vehicle{

    @Override
    public double calcFuelEfficiency() {
        log.info("卡车的......");
        return 0;
    }

    @Override
    public double calcTripDistance() {
        log.info("卡车的........");
        return 0;
    }
}
