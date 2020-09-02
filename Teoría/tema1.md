# Tema 1. Introducción a la PDOO

## 1. Programación Orientada a Objetos

### Primeros conceptos

#### Concepto de objeto

* > Entidad perfectamente delimitada, que encapsula estado y funcionamiento y posee una identidad (OMG 2001).

* > Elemento, unidad o entidad individual e identicable, real o abstracta, con un papel bien denido en el dominio del problema (Dictionary of Object Technology 1995).

* No tenemos los datos y los procedimientos separados, sino que todo es una entidad: _datos + procedimientos_.

#### Concepto de clase

* La **clase**, entre otras cosas, actúa de molde o plantilla para la creación de objetos. En algunos lenguajes las clases son también objetos a todos los efectos.
* Los objetos creados a partir de una clase se denominan **instancias** de esa clase. Esos objetos _pertenecen_ o simplemente _son_ de esa clase.
* Una clase crea un tipo de dato. Se pueden declarar variables de ese tipo o clase (si el lenguaje dispone de este mecanismo).

#### Concepto de identidad

* Cada instancia tiene su propia identidad.
* La identidad la dene la **posición de memoria**: independientemente de su estado, objetos distintos residirán en zonas de memoria distintas.
* _Piensa en dos gemelos idénticos, todos los aspectos en sus cuerpos pueden ser iguales pero no son la misma persona. Cada uno tiene su cuerpo, aunque ambos cuerpos sean idénticos._
* Dos objetos pueden compartir trozos de memoria. Si tuviesen la misma identidad, se trataría del mismo objeto.

#### Conceptos de estado y comportamiento

* El **estado** de un objeto vendrá denido por los valores de sus atributos. Cada objeto tiene una zona de memoria propia para el almacenamiento de sus atributos.
* Los objetos exhiben **comportamiento**. Disponen de una serie de métodos (funciones o procedimientos) que pueden ser llamados.

~~~c++
Clase instancia1,instancia2;
Clase *instancia3; //Puntero C++
//....
instancia1.metodo1() // Se invoca al método: metodo1
instancia2.metodo1() // otra instancia distinta
instancia3->metodo1() //c++
~~~

> En Java y en Ruby, todo son referencias (punteros, aunque no tendremos sintaxis a punteros).

### Paradigma de Programación Orientada a Objetos

* **Paradigma:** Teoría o conjunto de teorías cuyo núcleo central se acepta sin cuestionar y que suministra la base y modelo para resolver problemas y avanzar en el conocimiento (R.A.E).
* **Paradigma de programación:** un conjunto de reglas que indican cómo desarrollar software.
* **Base de la orientación a objetos:** se unen los datos y el procesamiento en entidades denominadas *objetos*.
  * A los objetos se les envían mensajes para realizar operaciones. Esas peticiones llevaran a la ejecución de métodos.
  * Conceptos básicos:
    * objeto e instancia
    * estado
    * clase
    * método
    * mensaje
    * herencia
    * polimorsmo
  * Hay más paradigmas, un problema puede resolverse de varias formas. La POO es más ineficiente en algunos casos, pero tiene muchas más ventajas, más facilidad de mantenimiento, etc.

### Primeros ejemplos

~~~java
package basico;	//> todo lo que hacemos en Java está en paquetes
				//> estamos creando el paquete basico

// Enumerado con visibilidad de paquete
/*public*/ enum ColorPelo { MORENO, CASTAÑO, RUBIO, PELIROJO }
	//> usar tipo enum en lugar de valores numéricos: más información
	//> no indicar el tipo de visibilidad significa que tiene visib. paquete

/*public*/ class Persona { // Clase con visibilidad de paquete
    private String nombre; // Atributos de instancia privados
    private int edad;
    private ColorPelo pelo;
    	//> en Java se pone private en CADA UNO
    
    public Persona (String n,int e,ColorPelo p) { // Constructor público
        nombre=n;
        edad=e;
        pelo=p;
    }
    void saluda() { // Visibilidad de paquete. Método de instancia
        System.out.println("Hola, soy "+nombre);
    }
}
public class Basico { //Clase con programa principal
    //> el main siempre tiene que pertenecer a alguna clase
    public static void main(String[] args) {
        Persona p=new Persona("Pepe",10,ColorPelo.RUBIO);
        p.saluda();
    }
}
~~~

~~~ruby
# encoding: UTF-8
#> el encoding debe estar en la línea 1, SIEMPRE

module Basico	#> module es el equivalente a los paquetes
    module ColorPelo	#> Ruby no tiene enum, lo simulamos con constantes
        				#  metidas dentro del módulo
        MORENO=   :moreno		#> : es un símbolo (siempre me refiero a lo mismo)
        CASTAÑO=  :castaño		#> todo lo que empieza por mayúscula es constante
        RUBIO=    :rubio		#  (basta que la primera sea mayúscula)
        PELIROJO= :pelirojo
    end

    class Persona	#> ha de empezar en mayúscula, es cte.
        			#  el nombre de los módulos tb ha de empezar en mayús.
        def initialize(n,e,p) # "constructor"
            #> es especial: es privado, siempre se llama así
            #  (inicializador de instancia)
            # Atributos de instancia (son privados)
            @nombre=n	#> @ hace que algo sea un atributo de instancia
            			#  si no existe, se crea y se incializa a lo que se pone
            @edad=e
            @pelo=p
        end

        public # aunque los métodos son públicos por defecto
        		#> afecta a todo lo que viene después
        def saluda # Método público de instancia
            #> en Ruby no se indica el tipo de nada, ni el devuelto, ni void...
            #> si no hay parámetros, ni siquiera podemos paréntesis
            puts "Hola, soy "+@nombre
            #> si hiciese:
            #      @pepe=25
            #  todas las instancias que ejecuten saluda tendrán un atributo extra
        end
    end

    #> en Ruby no hace falta tener un programa principal
    p=Persona.new("Pepe",10,ColorPelo::RUBIO)	#> :: para referir módulo
    	#> new es un método de la clase
    p.saluda
end

# ---------

# Fuera del módulo que hemos llamado "Basico"
p2=Basico::Persona.new("Manolo",20,Basico::ColorPelo::MORENO)
puts p2.inspect  #> nos muestra información sobre el objeto
#< Basico::Persona:0x5571 @nombre="Manolo",@edad=20,@pelo=:moreno >
	#> 0x5571 no es la dirección de memoria, es un identificador único del objeto
~~~

