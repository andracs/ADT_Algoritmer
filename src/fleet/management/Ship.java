/*
 *  Developed by András Ács (acsandras@gmail.com)
 *  Zealand / www.zealand.dk
 *  Licensed under the MIT License
 *  2019-04-03/04/2019
 *
 */
package fleet.management;

import java.time.Year;

public class Ship implements java.io.Serializable {

    private int IMO;
    private String name;
    private Year built;
    private int TEU;
    private int GT;
    private int DWT;
    private double length;

    public Ship() {
    }

    public Ship(String name) {
        this.name = name;
    }

    public Ship(int IMO, String name, Year built, int TEU, int GT, int DWT, double length) {
        this.IMO = IMO;
        this.name = name;
        this.built = built;
        this.TEU = TEU;
        this.GT = GT;
        this.DWT = DWT;
        this.length = length;
    }

    public String url() {
        // http://www.vesseltracking.net/ship/munich-maersk-9778806
        String base = "http://www.vesseltracking.net/ship/";
        String name =  this.name.replace(" ", "-") + "-";
        String imo = String.valueOf(this.IMO);
        return base + name + imo;
    }


    @Override
    public String toString() {
        return "Ship{" +
                "IMO=" + IMO +
                ", name='" + name + '\'' +
                ", built=" + built +
                ", TEU=" + TEU +
                ", GT=" + GT +
                ", DWT=" + DWT +
                ", length=" + length +
                '}';
    }

    public int getIMO() {
        return IMO;
    }

    public void setIMO(int IMO) {
        this.IMO = IMO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getBuilt() {
        return built;
    }

    public void setBuilt(Year built) {
        this.built = built;
    }

    public int getTEU() {
        return TEU;
    }

    public void setTEU(int TEU) {
        this.TEU = TEU;
    }

    public int getGT() {
        return GT;
    }

    public void setGT(int GT) {
        this.GT = GT;
    }

    public int getDWT() {
        return DWT;
    }

    public void setDWT(int DWT) {
        this.DWT = DWT;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
