package com.example.lab2;

public class Temperature {

    private  float temperature;

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float To_C(){
        return ((temperature-32)*5/9);
    }

    public float To_F(){
        return (((temperature*5)/9)+32);
    }
}
