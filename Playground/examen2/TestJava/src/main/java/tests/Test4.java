/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 * Tipos retornados en herencia // Override de privado
 */
class Test {
    public B metodo() {
        return new B();
    }
    
    private void met() {
        System.out.println("Test.met");
    }
}

public class Test4 extends Test {
    /*
    NO SE PUEDE hacer:
    public A metodo() {
        return new A();
    }*/
    
    /*
    SE PUEDE hacer:
    public B metodo() {
        return new B();
    }*/
    
    public C metodo() {
        return new C();
    }
    
    private void met() {
        System.out.println("Test4.met");
    }
    
    public static void main(String[] args) {
        Test4 t4 = new Test4();
        Test t = new Test();
        Test tzombie = new Test4();
        
        t4.met();   // podemos hacerlo
        //t.met();  // no estamos en la misma clase
        tzombie.met();
    }

}

class A {
    
}

class B extends A {
    
}

class C extends B {
    
}