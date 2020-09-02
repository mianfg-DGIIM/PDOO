/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractTest;

/**
 *
 * @author Miguel Ángel Fernández Gutiérrez, Sergio Quijano Rey
 */
public class MainClass {
    public static void main(String[] args) {
        System.out.println("abstractTest:\n");
        SerVivo.decir();
        SerVivo a = new SerVivo("3");
    }
}
