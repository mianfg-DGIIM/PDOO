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
public class Animal {
    void hablar() {
        System.out.println("Hablo como un animal");
    }
}

interface ObjetoVolador {
    
}

class Ave extends Animal implements ObjetoVolador {
    public void doo() {
        System.out.println("do");
    }
    
    void hablar() {
        System.out.println("Hablo como un ave");
    }
}

class Reptil extends Animal {
    void hablar() {
        System.out.println("Hablo como un reptil");
    }
}

class Gallina extends Ave {
    
}

class Pato extends Ave {
    @Override
    public void doo() {
        System.out.println("do2");
    }
}


// problema del contenedor

abstract class Figura {
    String color;
    
    Figura (String _color) {
        color = _color;
    }

    void dibujar() {
        System.out.println("Dibujo Figura");
    }
    
    String getColor() {
        return "2";
    }
}

class Triangulo extends Figura {
    Triangulo(String _color) {
        super(_color);
    }
    void dibujar() {
        System.out.println("Dibujo Triangulo");
    }
}

class Cuadrado extends Figura {
    // no se implementa por defecto? WIP
    Cuadrado (String _color) {
        super(_color);
    }
    void dibujar() {
        System.out.println("Dibujo Cuadrado");
    }
}

class Circulo extends Figura {
    Circulo(String _color) {
        super(_color);
    }
    void dibujar() {
        System.out.println("Dibujo Circulo");
    }
    
    float getRadio() {
        return 1;
    }
}

interface FiguraI {

    default void dibujar() {
        System.out.println("Dibujo Figura");
    }
    
    default String getColor() {
        return "2";
    }
}

class TrianguloI implements FiguraI {
    String color;
    TrianguloI(String _color) {
        color = _color;
    }
    @Override
    // WIP debe ser public ¿visibilidad en interfaces?
    public void dibujar() {
        System.out.println("Dibujo Triangulo");
    }
}

class CuadradoI implements FiguraI {
    // no se implementa por defecto? WIP
    String color;  // esto en interfaces?
    CuadradoI (String _color) {
        color = _color;
    }
    public void dibujar() {
        System.out.println("Dibujo Cuadrado");
    }
}

class CirculoI implements FiguraI {
    String color;
    CirculoI(String _color) {
        color = _color;
    }
    public void dibujar() {
        System.out.println("Dibujo Circulo");
    }
    
    float getRadio() {
        return 1;
    }
}
