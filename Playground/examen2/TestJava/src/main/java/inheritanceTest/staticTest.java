/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceTest;

/**
 *
 * @author Miguel Ángel Fernández Gutiérrez, Sergio Quijano Rey
 */
public class staticTest {

    public static void main(String[] args) {
        System.out.println(Padre.DECLASE); // 1
        System.out.println(Hija.DECLASE); // 2
        System.out.println(Nieta.DECLASE); // 2
        System.out.println(Padre.getDECLASE()); // 1
        System.out.println(Hija.getDECLASE()); // 1  WIP
        //porque "redefine" el método de clase
        System.out.println(Nieta.getDECLASE()); // 2
    }
}

class Padre {

    public static final int DECLASE = 1;

    public static int getDECLASE() {
        return DECLASE;
    }
}

class Hija extends Padre {

    public static final int DECLASE = 2; // Variable shadowing
}

class Nieta extends Hija {

    public static int getDECLASE() { // No es una redefinición
        //super.getDECLASE() No permitido
        return DECLASE;
    }
}
