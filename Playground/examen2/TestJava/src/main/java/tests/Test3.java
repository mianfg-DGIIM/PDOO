/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 * Accesibilidad en herencia
 */
public class Test3 {
    
}

// podemos hacer:
// package (en el mismo paquete o en cualquier otro)
// public (desde otro fichero)
// no:
// private
// public (en el mismo fichero)
class Test3h extends Test3 {
    
}


class Test32 {
    
}

// podemos hacer:
// package (en el mismo paquete)
// public (desde otro fichero en el mismo paquete)
// no:
// private
// public (en el mismo fichero)
// cualquier cosa desde otro paquete: tiene visibilidad de paquete
class Test32h extends Test32 {
    
}