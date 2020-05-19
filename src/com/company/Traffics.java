package com.company;

public class Traffics extends Thread {
    private static Car car;
    private static String carNumber;
    private static int distance;
    private static boolean way;

    public Traffics(int distnce, boolean way){
        this.distance = distnce;
        this.way = way;
    }

    public static synchronized void Go(){
        for(int i = 1; i <= 5; i++){
            carNumber = "Машина " + i;
            car = new Car(carNumber, distance, way);
            car.start();
            try {
                car.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        way = !way;
    }
    @Override
    public void run() {
        Go();
    }
}
