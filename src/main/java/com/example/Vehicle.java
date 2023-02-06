package com.example;

/**
 * \* Created with WXD.
 * \* Date:  2023/2/6
 * \* Description:
 * \* @author 王祥栋
 */
public abstract class Vehicle {
    /**
     * 计算燃料效率的抽象方法
     *
     * @return
     */
    public abstract double calcFuelEfficiency();

    /**
     * 计算行驶距离的抽象方法
     *
     * @return
     */
    public abstract double calcTripDistance();
}
