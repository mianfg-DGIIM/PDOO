/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

class Base {
    public void show() {
       System.out.println("Base::show() called");
    }
}
  
class Derived extends Base {
    public void show() {
       System.out.println("Derived::show() called");
    }
    public void metodo() {
        System.out.println("Hola");
    }
}
  
public class Main {
    public static void main(String[] args) {
        Base b = new Derived();;
        b.show();
        //b.metodo();
        
        Derived d = new Derived();
        d.show();
        d.metodo();
    }
}

class one {
    public int attr1;
    public int attr2;
    
    one(int at1, int at2) {
        attr1 = at1;
        attr2 = at2;
    }
    
    one() {
        attr1 = 1;
        attr2 = 2;
    }
    
    //llamada a constructores
    
    // un método static, otro método no static mismo nombre y distintos parámetros
    
    /*
    1) For class (or static) methods, the method according to the type of reference is called, not according to the object being referred, which means method call is decided at compile time.

2) For instance (or non-static) methods, the method is called according to the type of object being referred, not according to the type of reference, which means method calls is decided at run time.

3) An instance method cannot override a static method, and a static method cannot hide an instance method. For example, the following program has two compiler errors.


    */
}

/**
 *
 * @author Miguel Ángel Fernández Gutiérrez, Sergio Quijano Rey
 */
public class Test {
    
}
