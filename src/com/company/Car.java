package com.company;

public class Car extends Thread {
    private static final int speed = 10; //Допустимая скорость
    private String carNumber;
    private boolean way;

    public Car(String car, int distance, boolean way){
        this.carNumber = car;
        this.way = way; //В какую сторону едет машина, true - вправо, false - влево.
    }
    @Override
    public synchronized void run() {
        System.out.println(carNumber + " заехала на мост");
        try {
            TrafficOnBridge.Move(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String GerCarName(){
        return this.carNumber;
    }

    public boolean GetCarWay(){
        return  this.way;
    }


}
