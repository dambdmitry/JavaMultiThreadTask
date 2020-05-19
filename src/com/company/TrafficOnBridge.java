package com.company;

public class TrafficOnBridge{
    static final int bridgeLength = 150;
    static final int speed = 10;

    public synchronized static void Move(Car car) throws InterruptedException {
        char[] arrayRoad = array();
        String road = "";
        int range = 0;
        while(range < bridgeLength){
            range += speed;
            if(car.GetCarWay()) {
                arrayRoad[range / speed] = '#';
            }else{
                arrayRoad[arrayRoad.length - range / speed - 1] = '#';
            }
            road = Road(arrayRoad);
            System.out.println(car.GerCarName() + " " + road);
            car.sleep(100);
        }
    }

    private static char[] array(){
        char[] road = new char[(int)(bridgeLength/speed + 2.5)];
        road[0] = '[';
        road[road.length - 1] = ']';
        for(int i = 1; i <= (int)bridgeLength/speed + 0.5; i++){
            road[i] = '-';
        }
        return road;
    }
    private static String Road(char[] array){
        String road = "";
        for(int i = 0; i <= array.length - 1; i++){
            road += array[i];
        }
        return road;
    }

}
