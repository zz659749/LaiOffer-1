package LaiOffer;

public class Car {
    String brand;
    String model;
    int year;
    String owner;
    int plateNum;
    String color;
    Boolean rent;
    int mileage;
    //-------------------------constructors-------------------------------
    public Car() {
    }

    public Car(String brand, String model, int year, String owner, int plateNum, String color, Boolean rent, int mileage) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.owner = owner;
        this.plateNum = plateNum;
        this.color = color;
        this.rent = rent;
        this.mileage = mileage;
    }

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    //-------------------------useful functions-------------------------------

    public void changeOwner(String owner, Boolean isRent) {
        this.owner = owner;
        if (isRent) {
            rent = true;
        }
    }

    public void drive(int miles) {
        mileage += miles;
    }



    //-------------------------getter && setter-------------------------------
    public void setPlateNum(int plateNum) {
        this.plateNum = plateNum;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getOwner() {
        return owner;
    }

    public int getPlateNum() {
        return plateNum;
    }

    public String getColor() {
        return color;
    }

    public int getMileage() {
        return mileage;
    }





}
