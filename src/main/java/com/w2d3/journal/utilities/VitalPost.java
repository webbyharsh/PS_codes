package com.w2d3.journal.utilities;


public class VitalPost {
    public Integer heartRate;
    public Integer spo2;
    public Double temperature;
    public String timeStamp;

    public VitalPost(int heartRate, int spo2, double temperature, String timeStamp){
        this.heartRate = heartRate;
        this.spo2 = spo2;
        this.temperature = temperature;
        this.timeStamp = timeStamp;
    }


}
