package com.afaqy.service.oop;

class Bicycle {

    private int gear;
    private int speed;

    public Bicycle(int gear, int speed) {
        System.out.println("Super class constructor");

        setGear(gear);
        setSpeed(speed);
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }

}

class MountainBike extends Bicycle {

    private int seatHeight;

    public MountainBike(int gear, int speed, int startHeight) {
        super(gear, speed);
        System.out.println("Sub class constructor");

        System.out.println("Sub class name: " + this.getClass().getName());
        System.out.println("Super class name: " + super.getClass().getName());
        System.out.println();

        setSeatHeight(startHeight);
    }

    public int getSeatHeight() {
        return seatHeight;
    }

    public void setSeatHeight(int seatHeight) {
        this.seatHeight = seatHeight;
    }

}

public class InheritanceDemo {

    public static void main(String[] args) {

        MountainBike mb = new MountainBike(3, 90, 25);
        mb.applyBrake(10);
        mb.speedUp(20);

        System.out.println("No of gears are: " + mb.getGear());
        System.out.println("Speed is: " + mb.getSpeed());
        System.out.println("Seat height is: " + mb.getSeatHeight());
    }

}
