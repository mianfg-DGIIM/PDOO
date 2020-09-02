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
public class MainClass {
    public static void main(String[] args) {
        System.out.println("inheritanceTest:\n");
        Saludo.diAlgo();
        MiSaludo.diAlgo();
        Rectangulo r = new Rectangulo(4,4);
        r.pintarBorde("negro");
        double perimetro = r.perimetro();
        double area = r.area();
        
        
        Ave var1;
        //var1 = new Animal();
        var1 = new Ave();
        var1.doo();
        var1 = new Pato();
        var1.doo();
        //var1 = new Reptil();
        
        ObjetoVolador var2;
        //var2 = new Reptil();
        var2 = new Ave();
        var2 = new Pato();
        
        Object var = new Ave();
        //var.doo(); 
        ((Ave)var).doo();
        
        Animal animal = new Animal();
        Reptil reptil = new Reptil();
        animal.hablar();
        reptil.hablar();
        animal = reptil;
        animal.hablar();
        reptil.hablar();
        //reptil = animal;  // error en compilación
        reptil = (Reptil) animal;  // error en ejecución  NO DA XD WIP
        animal.hablar();
        reptil.hablar();
        
        Animal animal2 = new Animal();
        Animal reptil2 = new Reptil();
        animal2.hablar();
        reptil2.hablar();
        reptil2 = animal2;
        animal2.hablar();
        reptil2.hablar();
        
        
        // problema del contenedor
        Figura[] figuras = new Figura[3];
        figuras[0] = new Cuadrado("rojo");
        figuras[1] = new Circulo("azul");
        figuras[2] = new Cuadrado("verde");
        
        for ( Figura figura : figuras ) {
            System.out.println(figura.getColor());
            figura.dibujar();
            // ((Circulo)figura).getRadio(); error ejecución
            if ( figura instanceof Circulo )
                ((Circulo) figura).getRadio();
        }
        
        FiguraI[] figs = new FiguraI[3];
        figs[0] = new CuadradoI("rojo");
        figs[1] = new CirculoI("azul");
        figs[2] = new CuadradoI("verde");
        
        for ( FiguraI fig : figs ) {
            System.out.println(fig.getColor());
            fig.dibujar();
            ((CirculoI)fig).getRadio();
            // ((Circulo)figura).getRadio(); error ejecución
            
        }
    }
}


interface Inter {
    int a = 5;
    void a();
    static void c() {
        print();
    }
    default void b() {
        
    }
}