/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceTest;

/**
 *
 * @author Miguel Ángel Fernández Gutiérrez, Sergio Quijano Rey
 */
public interface FiguraGrafica {
    static final int grosorBorde=2;
    public void pintarBorde(String color);
    public void colorear(String color);
}

abstract class FiguraGeometrica {
    private int numLados;
    public FiguraGeometrica(int lados) {
        this.setNumLados(lados);
    }
    public abstract double perimetro();
    public abstract double area();
    public abstract double girar();
    public void setNumLados(int numL) {numLados=numL;}
    public int getNumLados() {return numLados;}
}

class Rectangulo extends FiguraGeometrica implements FiguraGrafica {
    private double ladoa, ladob;
    public Rectangulo(double la, double lb) {
        super(4);
        ladoa = la;
        ladob = lb;
    }
    @Override
    public double perimetro() { return 2*ladoa + 2*ladob; }
    @Override
    public double area() { return ladoa*ladob; }
    @Override
    public void pintarBorde(String color) {
        System.out.println("Pintando borde de "+color);
    }
    @Override
    public void colorear(String color) {
        System.out.println("Coloreando de "+color);
    }
    @Override
    public double girar() {
        return 3;
    }
}

interface Fig {
    void lado();
}

