package com.example.apirestwithswagger.service;

import com.example.apirestwithswagger.entities.Hardware;

//method for it calculate total cost of the hardware
public class HardwarePriceCalculator {
    public static double calculatePrice(Hardware hardware){
        double price = hardware.getPrice();
        //discount for buying more than a dozen
        if(hardware.getHardwareNumber() >= 12){
            price -= 1;
        }
        //cost of send
        price += 1.99;
        return price;
    }
}
