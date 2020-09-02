# Tema 2

## 2. Atributos y métodos

### Atributos de instancia: _estado_

* Son los atributos de la instancia de la clase. Al definir una clase, se indican qué atributos tendrán todas las instancias de la clase.
* La descripción de las clases incluye los atributos de instancia de cada objeto que es instancia de esa clase.
* Los atributos de instancia son variables que están **asociadas a cada objeto**.
* Cada instancia tiene su **propio espacio** de atributos o variables de instancia.
* Así, cada instancia tendrá los mismos atributos que otra instancia de la misma clase, pero en zonas de memoria distintas.
  * Por tanto, los atributos no definen la identidad: es posible que dos instancias tengan los mismos atributos, pero no se traten de la misma instancia.
* El estado de cada instancia se describe mediante los valores de estos atributos.

##### Clase `Persona`

* Todas las instancias de la clase `Persona` tendrán un atributo denominado `nombre`.
* Esto se traduce en una variable denominada `nombre` para cada instancia.
* Dos instancias de `Persona` distintas almacenan el nombre en variables distintas (almacenadas en zonas de memoria distintas) aunque se llamen igual.

### Métodos de instancia: _funcionalidad_

* Son **funciones o procedimientos asociados a los objetos instancias** de las clases.
* Pueden alterar o consultar el estado interno del objeto para realizar su cometido.

### Atributos de clase

* Almacenan información que se considera asociada a la propia clase y no a cada instancia.
* Son por tanto variables asociadas a la clase y **globales a todas las instancias** de esa clase.
* Cada atributo de clase existe de forma única.
* **Debemos evitar, en general, las variables globales. Aunque este es un caso un tanto especial, no es global _per-se_, es _global a la clase_.**

#### Particularidad de Ruby

* Existen dos tipos de atributos de clase:
  * **Atributos de clase (`@@atributo_de_clase`).** Los atributos de clase son accesibles directamente en el ámbito de instancia.
  * **Atributos de instancia de la clase (`@atributo_instancia_clase`).** Los atributos de instancia de la clase, no. En general, es más recomendable usar estos aunque haya que escribir un poco más de código.
* Los atributos de clase se comparten con las subclases (herencia). Esto puede ser muy peligroso. Los atributos de instancia de la clase, no.
* En Ruby, las clases en sí también son objetos. En Java, no.

##### Clase `Persona`

* Se podría estar interesado en registrar la cuenta del número de Personas (instancias de `Persona`) creadas.
* El contador de personas sería un atributo de la clase `Persona`.
* No tendría sentido que cada instancia de `Persona` guardase una copia del valor almacenado en ese contador. Esto además haría su actualización extremadamente costosa.

### Métodos de clase

* Son funciones y procedimientos asociados a la propia clase.

* Es habitual que **accedan/actualicen atributos de clase**.

* **No se puede acceder directamente a atributos/métodos de instancia desde un método de clase.** Sería necesario solicitar ese elemento a una instancia concreta.

  _No se puede hacer:_

  ~~~
  begin
  	metodoInstancia()
  end
  ~~~

* En muchos casos, los métodos de clase acaban siendo métodos auxiliares.

---

~~~ruby
class Sociedad
    @@num_personas	# atrib. clase
    @mayoria_edad	# atrib. de instancia de la clase
    
    def initialize
        @persona
    end
    
    def self.edad_legal	# método de clase
        puts "hola, tienes " + @mayoria_edad	# es de instancia de la clase
    end
    
    def mayor_de_edad
        return ( edad >= self.class.edad_legal )
    end
end
~~~

~~~ruby
class Producto
    @@iva = 21	# atrib. clase
    
    def instanciaSetIva(iv)	# método de instancia
        @@iva = iv
        #> se puede llamar a un atributo de clase dentro de un método de instancia, pero no es recomendable. No se podría llamar a un atributo de instancia de la clase
~~~

###### Visibilidad en Ruby

Por defecto, los métodos son `public` y no hay visibilidad de paquete. Los atributos son siempre privados y sólo puede acceder a ellos el mismo objeto (otro de la clase no).

Los métodos se declaran así:

~~~ruby
class Prueba
    private
    def metodo_instancia_privado
        puts "privado de instancia"
    end
    def metodo2
        puts "¿privado?"
    end
    def metodo_clase_privado
        puts "Soy privado y de clase"
    end
    
    private :metodo2
    private :metodo_clase_privado
~~~



---

##### Clase `Persona`

- Método para actualizar el contador de personas.

---

~~~java
public class Persona {
    private static final int MAYORIAEDAD=18; // Atributo de clase
    	//> static es el que hace que sea un atributo de clase (proviene de C)
    	//  (ampliación: indagar sobre static en C)
    	//> final hace que sea una constante
    	//  nota: los métodos final no son los métodos const de C++
    private LocalDateTime fechaNacimiento;   // Atributo de instancia
    	//> es de instancia porque no hemos puesto static
    
    Persona(LocalDateTime fecha) {
        fechaNacimiento=fecha;
    }
    
    public boolean mayorDeEdad() { // Método de instancia
        //> no pone static (los métodos de clase se ponen con static)
        LocalDateTime ahora = LocalDateTime.now(); // Llamada a método de clase
        // "ahora" es una variable local
        //> además, su nombre no coincide con un atrib. de instancia
        //  si colocamos el mismo, Java nos advertirá
        
        //! DUDA: en caso de que declaremos en un método una variable del mismo
        //  nombre, ¿qué pasa con el atributo?
        
        //> los métodos de clase se invocan con NombreClase.metodo()
        //  los métodos de instancia se invocan con nombre_instancia.metodo()
        
        // Años completos transcurridos
        long edad = ChronoUnit.YEARS.between(fechaNacimiento,ahora);
        //! between es un método, ChronoUnit es una clase, YEARS ¿?
        
        return (edad>=MAYORIAEDAD);
    }
}
~~~

> **¡CUIDADO!** -- No confundir "atributo estático" con "atributo de clase".

~~~ruby
require 'date' #> se asume la extensión date.rb, se encuentra en los paquetes
			   #  donde esté instalado Ruby
class Persona
    @@MAYORIA_EDAD=18  # Atributo de clase
    #> es constante porque empieza en mayúscula
    
    def initialize(fecha)	#> también es método de instancia
        @fecha_nacimiento=fecha  # Atributo de instancia
        #> aquí indicamos que tenemos el atrib. de instancia fecha_nacimiento
    end
    
    #> en Ruby si estoy fuera de cualquier método se considera ámbito de clase
    
    def mayor_de_edad # Método de instancia
        ahora=Date.today # "ahora" es una variable local
        #> today es un método de clase de la clase Date
        edad=ahora.year-@fecha_nacimiento.year-1
        if (ahora.month>@fecha_nacimiento.month)
            edad+=1
        else
            if (ahora.month==@fecha_nacimiento.month)
                if (ahora.day>=@fecha_nacimiento.day)
                    edad+=1
                end
            end
        end
        return (edad>=@@MAYORIA_EDAD)
        #> en Ruby todo son funciones, no procedimientos
        #  por defecto se devuelve lo último que se haya calculado
        #  por tanto, en este caso no hace falta hacer return
    end
end
~~~

Versión con atributos de instancia de la clase:

~~~ruby
class Persona
    @MAYORIA_EDAD=18 # Atributo de instancia de la clase
    #> necesariamente tiene que ir aquí, porque estamos en ámbito de clase
    #  si estuviese en una instancia, sería un atributo de instancia
    #  NO podemos usarlos en métodos de instancia: si asignamos creamos un atributo
    #  de instancia, si lo usamos daría nil
    
    def self.edad_legal # Método de clase (Persona.edad_legal)
        #> también podríamos poner Persona.edad_legal
        #> def realmente es un método que tiene la clase, le pasamos self.edad_legal
        @MAYORIA_EDAD
    end
    
    def initialize(fecha)
        @fecha_nacimiento=fecha # Atributo de instancia
    end
    
    def mayor_de_edad # Método de instancia
        ahora=Date.today
        edad=ahora.year-@fecha_nacimiento.year-1
        if (ahora.month>@fecha_nacimiento.month)
            edad+=1
        else
            if (ahora.month==@fecha_nacimiento.month)
                if (ahora.day>=@fecha_nacimiento.day)
                    edad+=1
                end
            end
        end
        #! probar:
        #  put @MAYORIA_EDAD
        return (edad>=self.class.edad_legal) # (Persona.edad_legal)
        #> self.class es una forma de preguntar por su clase
        #  podríamos hacer Persona.edad_legal
    end
end
~~~

---

~~~ruby
class Producto
    @@iva = 21 # En mayúscula sería constante
    def initialize(precio, nombre)
        @precio=precio	#> atributos de instancia
        @nombre=nombre
    end
    def instanciaSetIVA(iv)	#> método de instancia
        # Acceso directo a un atributo de clase desde un método de instancia
        @@iva=iv
        # Esto no es posible con atributos de instancia de la clase
        #> NO es recomendable
    end
    
    #> esta es una mejor opción: no hace falta ninguna instancia para llamarlo
    def self.claseSetIVA(iv)
        # Acceso directo a un atributo de clase desde un método de clase
        @@iva=iv
    end
    
    #> representación en forma de string del contenido de la clase
    #  se usa mucho en POO
    #  en Java se suele llamar toString
    #  se usa mucho en depuración
    def to_s
        "nombre: #{@nombre}, precio: #{@precio}, iva: #{@@iva}"
    end
end
~~~



## 3. Construcción de objetos

### Cuestiones generales

* Antes de que los objetos puedan ser utilizados es necesario crearlos.
* La creación implica la reserva de memoria y la inicialización.
* Normalmente, el programador no tiene que ocuparse de la reserva de memoria en sí misma, pero sí de la inicialización.
* En algunos lenguajes el programador decide dónde se alojará cada objeto (pila o _heap_).

### Constructores

* Los lenguajes orientados a objetos suelen disponer de unos métodos especiales denominados **constructores**.
* A pesar de su nombre, estos métodos sólo se encargan de la inicialización de las instancias.
* En general, estos métodos no pueden ser invocados directamente, no son métodos de instancia y no especifican ningún tipo de retorno.
  * Existen diferencias importantes a este respecto en los distintos lenguajes de programación orientados a objetos.

* **Clases-plantilla:** en muchos casos tienen el mismo nombre de la clase y son invocados automáticamente utilizando la palabra reservada `new`.
* **Clases-objeto:** pueden tener un nombre arbitrario y suelen ser métodos de clase.

#### Java

* Tienen el mismo nombre de la clase y no devuelven nada, tampoco `void`.
* Se utilizan únicamente para asegurar la inicialización de los atributos.
* Al permitir la sobrecarga de métodos, puede haber varios con distintos parámetros.
* Se puede reutilizar un constructor desde otro constructor.
* Para construir un objeto se antepone la palabra reservada `new` al nombre de la clase.
* Si no se crea ningún constructor existe uno por defecto sin parámetros.

~~~java
class Point3D {
    // Atributos de instancia
    private int x;
    private int y;
    private int z;
    
    Point3D(int a, int b, int c) {	// Constructor
        x=a;
        y=b;
        z=c;
    }
}
~~~

~~~java
class RestrictedPoint3D {
    private static int LIMITMAX = 100;	// Atributo de clase
    private static int LIMITMIN = 0;	// Atributo de clase
    private int x;						// Atributo de instancia
    private int y;						// Atributo de instancia
    private int z;						// Atributo de instancia
    
    private int restrictToRange(int a) {	// Método de instancia
        int result = Math.max(LIMITMIN, a);
        result = Math.min(result, LIMITMAX);
        return result;
    }
    
    RestrictedPoint3D(int x, int y, int z) {	// Constructor
        this.x=restrictToRange(x);
        this.y=restrictToRange(y);
        this.z=restrictToRange(z);
        // usamos this para evitar confusión con parámetros
    }
    
    RestrictedPoint3D(int x, int y) {	// Constructor
        // llamamos al otro constructor
        this(x, y, 0);		// DUDA
    }
}

public static void main (String[] args) {
    RestrictedPoint3D p1 = new RestrictedPoint3D(-1, 101, -2000);
    RestrictedPoint3D p2 = new RestrictedPoint3D(1, 99);
    RestrictedPoint3D p3 = new RestrictedPoint3D(50, 51, 52);
}
~~~

#### Ruby

* El equivalente al constructor es un método especial `initialize`.
* Este método de instancia privado es llamado automáticamente por el método de clase `new`.
* `initialize` se encarga de la creación e inicialización de atributos de instancia.
* Cualquier método de instancia puede crear atributos de instancia. Lo recomendable es limitar esta labor al método `initialize`.
* No se puede sobrecargar `initialize` (ni ningún otro método --DUDA--).

Varios constructores:

* Se pueden crear métodos de clase que cumplan el cometido de los constructores (igual que `new`).
* Se podría hacer que `initialize` admita un número variable de elementos.

~~~ruby
class RestrictedPoint3D
    # Atributos de clase
    @@LIMIT_MAX = 1000
    @@LIMIT_MIN = 0
    
    private
    def restrict_to_range(a)	# método de instancia
        result = [@@LIMIT_MIN, a].max
        result = [@@LIMIT_MAX, result].min
        result
    end
    
    def initialize(x, y, z)		# creación e inicialización de atrib. instancia
        @x = restrict_to_range(x)
        @y = restrict_to_range(y)
        @z = restrict_to_range(z)
    end
end

puts RestrictedPoint3D.new(-1,1,1).inspect
~~~

~~~ruby
class RestrictedPoint3D
    # Añadimos al código anterior...
    
    def self.new_3D(x,y,z)	# método de clase
        new(x,y,z)
    end
    
    def self.new_2D(x,y)	# método de clase
        new(x,y,0)
    end
    
    private_class_method :new	# pasa a ser privado
end

puts RestrictedPoint3D.new_3D(-1,101,-2000).inspect
puts RestrictedPoint3D.new_2D(1,99).inspect
puts RestrictedPoint3D.new_3D(50,51,52).inspect
puts RestrictedPoint3D.new_3D(-2000,50,2000).inspect
# puts RestrictedPoint3D.new(-1,1,1).inspect # new es ahora privado
~~~

~~~ruby
def initialize(x, y, *z)
    # *z es un array con el resto de parámetros que se pasan
    @x = restrict_to_range(x)
    @y = restrict_to_range(y)
    if (z.size!=0) then
        z_param=z[0]
    else
        z_param=0
    end
    @z = restrict_to_range(z_param)
end
    
puts RestrictedPoint3D.new(1,2,3,4,5,6).inspect
# los parámetros extra son ignorados
~~~

~~~ruby
def initialize(x, y, z=0)
    # z tiene un valor por defecto
    @x = restrict_to_range(x)
    @y = restrict_to_range(y)
    @z = restrict_to_range(z)
end

puts RestrictedPoint3D.new(1,2).inspect
puts RestrictedPoint3D.new(1,2,3).inspect
~~~

~~~ruby
# Parámetros nombrados con valores por defecto
def initialize(x:, y:, z:0)
    @x = restrict_to_range(x)
    @y = restrict_to_range(y)
    @z = restrict_to_range(z)
end

puts RestrictedPoint3D.new(x:-1,y:101,z:-2000).inspect
# Puedo cambiar el orden
puts RestrictedPoint3D.new(y:2,z:3,x:1).inspect
puts RestrictedPoint3D.new(x:1,y:99).inspect
~~~

### Memoria dinámica y pila

* En Java y Ruby todos los objetos se crean en memoria dinámica (_heap_).
* En ambos lenguajes las variables contienen referencias a objetos. Hay algunas excepciones como los tipos primitivos de Java (`int`, `float`, etc.).
* Cuando se devuelve el valor de una variable se está por tanto devolviendo una referencia a un objeto.

### Liberación de memoria

* Java y Ruby disponen de un **recolector de basura** que libera la memoria utilizada por objetos no referenciados.
* En otros lenguajes es el programador el responsable de la liberación de la memoria reservada en el _heap_ (C++).

## 4. Consultores y modificadores

### Consultores

* Métodos encargados de devolver el valor de un atributo.
  * No tienen por qué limitarse a devolver ese valor. Pueden devolverlo modificado, una copia del mismo, etc.
* Se nombran habitualmente:
  * `getAtributo()` en Java.
  * `atributo` en Ruby.
* Sólo deben de crearse los que sean **necesarios**: se expone el estado interno al exterior.
* ¿Usarlos dentro de los constructores?

### Modificadores

* Métodos encargados de modificar el valor de un atributo.
  * No tienen necesariamente que limitarse fijar el valor recibido. Pueden y deben controlar las restricciones sobre ese atributo.
* Pueden ser de clase o de instancia.
* Se nombran habitualmente:
  - `setAtributo()` en Java.
  - `atributo` en Ruby.
* Sólo deben de crearse los que sean **necesarios**: se expone el estado interno al exterior.
* ¿Usarlos dentro de los constructores?

~~~java
public class Persona {
	private static final int MAYORIAEDAD=18; //Atributo de clase
	private LocalDateTime fechaNacimiento;   //Atributo de instancia

    Persona(LocalDateTime fecha) {
        fechaNacimiento=fecha;
    }
    
    public static int getMayoriaEdad() {
        return MAYORIAEDAD;
    }
 
    public LocalDateTime getFechaNacimiento() {
         //Se devuelve al exterior del objeto una referencia a la fecha
         return fechaNacimiento;
 	}
 
    public void setFechaNacimiento(LocalDateTime fecha) {
         //Añadir comprobaciones relativas a las restricciones sobre la edad
         fechaNacimiento=fecha;
    }
}

...
    
Persona p=new Persona(LocalDateTime.of(2000,7,5,0,0));
// utilizamos el modificador
p.setFechaNacimiento(LocalDateTime.of(1950,7,5,0,0));
// utilizamos el consultor
System.out.println(p.getFechaNacimiento());
// utilizamos el consultor de clase
System.out.println(Persona.getMayoriaEdad());
~~~

~~~ruby
require 'date'
class Persona
     @@MAYORIA_EDAD=18 # Atributo de clase
     def initialize(fecha)
     	@afecha_nacimiento=fecha
     end
     attr_reader :fecha_nacimiento # consultor
     attr_writer :fecha_nacimiento # modificador
     attr_accessor :fecha_nacimiento # consultor + modificador
     def self.MAYORIA_EDAD=e # modificador de clase
     	@@MAYORIA_EDAD=e
     end
end
~~~

~~~ruby
require 'date'
class Persona
    @@MAYORIA_EDAD=18 # Atributo de clase
    def initialize(fecha)
        @fecha_nacimiento=fecha
    end
    def fecha_nacimiento # consultor
        # Se devuelve al exterior del objeto una referencia a la fecha
        @fecha_nacimiento
    end
    def fecha_nacimiento=fecha # modificador #> podríamos colocar =(fecha)
     						                 #  (porque recibe un parámetro)
        # ¿ Restricciones ?
        @fecha_nacimiento=fecha
    end
    
    #> Cuando hagamos:
    #	p = Persona.new(___)
    #	p.fecha_nacimiento=___
    #		El nombre de la función es fecha_nacimiento=
    
    def self.MAYORIA_EDAD=e # modificador de clase
        @@MAYORIA_EDAD=e
    end
end
~~~

~~~ruby
p = Persona.new(Date.new(2000,7,3))

# utilizamos el modificador
p.fecha_nacimiento = Date.new(2000,8,3)

# utilizamos el consultor
puts p.fecha_nacimiento

# utilizamos el modificador de clase
Persona.MAYORIA_EDAD = 21
~~~

~~~ruby
class UnaClase
    attr_reader :atr1
    attr_accesor :atr2
    attr_writer :atr3
    
    def initialize(un, dos, tres)
        @atr1=un
        @atr2=dos
        @atr3=tres
    end
end

obj = UnaClase.new(1,2,3)
obj.atr2=8
puts obj.inspect
obj.atr2=9
puts obj.inspect
obj.atr3=7
puts obj.inspect
puts obj.atr1
puts obj.atr2
#puts obj.atr3 # no existe consultor
#obj.atr1 = 23 # no existe modificador
~~~

> En Ruby no se pueden sobrecargar funciones, es decir, no puede haber dos funciones con el mismo nombre.



## 5. Elementos de agrupación. Paquetes y módulos

### Paquetes Java

* Permiten agrupar clases.
* Constituyen un espacio de nombres. Es posible tener varias clases que se llamen igual en paquetes distintos.
* Es necesario indicar que se van a usar elementos de un paquete distinto al actual (`import`).
* Cada paquete Java es independiente del resto aunque a nivel de nombrado (y de almacenamiento en disco) parezca que pueden crear subpaquetes.
  * El paquete `A` y el paquete `A.B`puede parecer que estén relacionados, pero son diferentes. No se puede decir que esté uno dentro de otro (**¡cuidado!**: desde el _punto de vista de la programación_, si estamos en `A.B` no tenemos acceso a lo que tiene visibilidad de paquete de `A`. Esta jerarquía se obedece al almacenar los paquetes, pero a nivel de programación es indiferente).

---

* Los paquetes: `paquetePDOO` y `paquetePDOO.tema1` son paquetes distintos e independientes a nivel de código.

  * Si desde `paquetePDOO.tema1` se desea utilizar una clase definida en `paquetePDOO` (y viceversa) hay que indicarlo explícitamente (_import_).
  * Desde `paquetePDOO` no se tiene acceso a los elementos con nivel de acceso de paquete de `paquetePDOO.tema1` (y viceversa).

* Todos los ficheros que contengan elementos de `paquetePDOO` comenzarán con la línea:

  ~~~java
  package paquetePDOO; // se usan nombres que comiencen en minúsculas
  ~~~



###### Cómo se importa algo + `ArrayList`

~~~java
import java.util.ArrayList; // import java.util.*;
//> importa la clase ArrayList del paquete java.util

public class Test {
	private ArrayList<String> nombres = new ArrayList<>();
}
~~~

> **Ejercicio:** investigar sobre funcionamiento de `ArrayList`.



### Módulos Ruby

* Permiten agrupar una gran variedad de elementos: clases, constantes, funciones, otros módulos, etc.

* Constituyen un espacio de nombres.

* Para utilizar un elemento de un módulo hay que anteponer `<NombreModulo>::`.

* Particularidad Ruby: se puede copiar todo el contenido de un módulo dentro de una clase (_include_).

  * **No hacerlo** (todavía).

  * Este _include_ no es el `include` de C++.

    ~~~ruby
    require 'singleton'  #> indicamos que busque el fichero singleton.rb
    					 #  en las rutas por defecto del intérprete de Ruby
    					 #  (pues no hemos especificado una ruta)
    
    class Ejemplo
        include Singleton
    end
    ~~~

    > Estoy creando una clase `Ejemplo` y estoy incluyendo el contenido del módulo `Singleton`. Para que encuentre el módulo debemos de decirle en qué fichero está, para eso ponemos el `require`, el cual se parece más al `include` de C++.



~~~ruby
module Externo
    class A
    end
    module Interno
        class B
        end
    end
end

module Test
    def test
        puts "Testeando"
    end
end

class C
    include Test # mixin
    #> copiamos todo lo que hay después de module Test hasta el end
end

a=Externo::A.new
b=Externo::Interno::B.new
c=C.new
c.test
~~~

> Un fichero Ruby puede contener tantos módulos como queramos



#### Elementos en otros ficheros

* Si se desean utilizar elementos definidos en un fichero desde otro, es necesario que el segundo cargue el primero.
* `require` y `require_relative` (archivos en la misma ruta) permiten cargar en un fichero el contenido de otro. Evitan cargar varias veces el mismo fichero.
  * Esto solo es necesario principalmente **si se hace referencia al nombre de una clase**.
  * No es necesario si simplemente utilizan métodos de instancia de clases denidas en otros ficheros.
  * Cuidado con esto, porque puede ser que hagamos **dependencias circulares**.

~~~ruby
# fichero a.rb
class A
    def hacer
        puts "Haciendo"
    end
end
~~~

~~~ruby
require_relative 'a' # sin extensión
a=A.new
a.hacer
~~~

***Duck typing:*** _if it looks like a duck, and quacks like a duck, it's a duck._

~~~ruby
# Aunque esperemos recibir una instancia de A como parámetro
# para usar el método hacer, no hace falta cargar a.rb
class C
    def metodo1(a)
        a.hacer
    end
end
~~~

> Cada trozo de código está en un fichero distinto



###### Dependencia circular básica

~~~ruby
# fichero a.rb
require_relative 'b'

class A
end
~~~

~~~ruby
# fichero b.rb
require_relative 'a'

class B
end
~~~

Una forma de resolverlo es, en el fichero a:

~~~ruby
# fichero a.rb
require_relative 'b'

class B
end

class A
end
~~~



---

~~~java
package clase20;
import java.util.ArrayList

class Prueba {
    static private int DECLASE=43;
    static private void deClase() {}	// método de clase
    
    private ArrayList<Integer> contenedor;
    // Java permite inicializar atributos de instancia en la línea donde se declara
    // un poco feo
    
    // este private es para no hacer p.contenedor, pero una vez que tenemos las
    // referencias podemos hacer lo que queramos
    
    public Prueba(/*no hace falta recibir un contenedor*/) {
    	contenedor = new ArrayList();
    	// por cada atributo que tenga, no hace falta pasarle un parámetro al constr.
    	contenedor.add(new  Integer(-1));
    	// Integer es una clase, sólo podemos crear ArrayList de objetos (no de int)
    }
    
    ArrayList<Integer> getContenedor() {
    	Prueba p = new Prueba();
    	// este objeto no es destruido, al salir de getContenedor perdemos la
    	// referencia, se eliminará cuando decida el recolector de basura
    	return contenedor;
    	
    	// alternativa 2:
    	return (new ArrayList(contenedor));
    	// copia referencias, el ArrayList tiene las mismas referencias
    	// sin embargo, los objetos de Integer son inmutables, cuando se hace una
    	// operación sobre el Integer se hace un integer nuevo (sería como una copia)
    	// esto no es aplicable en general
    	// como estamos devolviendo una referencia, aunque creemos un objeto en la
    	// función devolvemos una referencia, por lo que el recolector de basura no
    	// eliminará dicho objeto (está siendo referenciado)
    }
    
    public int getNElementos() {
    	return contenedor.size();
    }
    
    public void metodo() {}
    private void metodo2() {
        Prueba p = new Prueba();
        // no podemos llamar a un objeto si no hemos construido el objeto (new)
        p.metodo2();	// compilar compila ;)
        
        DECLASE=67;
        deClase();
        Prueba.deClase();	// también puede hacerse
        
        p.deClase();		// no da error, pero es horrible ¡no hacerlo!
        this.deClase();		// tampoco...
        
    }
}

// Java no puede tener dos clases públicas en un mismo fichero
public class Clase20 {
    public static void main(String [] args) {
    	Prueba p = new Prueba();
    	p.metodo();
    	//p.metodo2(); //NO PUEDO
    	
    	ArrayList<Integer> interior = p.getContenedor();
    	// se pasa como referencia
    	System.out.println(interior.size());  // sale 1
    	interior.clear();
    	System.out.println(interior.size());  // ahora sale 0
    	System.out.println(p.getNElementos());  // también sale 0
    	// ¡lo hemos modificado! una vez que tengo la referencia, todo lo que haga
    	// lo hago sobre esa referencia
    }
}
~~~

~~~RUBY
class Prueba
    def self.de_clase
        p=Prueba.new
        p.metodo2	# error
    end
    
    public def metodo1()
        p=Prueba.new
        p.metodo2
    end
        
    private def metodo2()	# error aquí
    end
end

Prueba.de_clase		# error
Prueba.new.metodo1	# error

# Cada instancia puede acceder a lo privado suyo
~~~

## UML diagramas de interacción

### Diagrama de clases

Muestra las clases y sus relaciones:

* Dependencia.
* Asociación.
* Generalización.
* Realización.

#### Visibilidad y scope

`+` público

`-` privado

`#` protegido

`~` paquete

De clase está <u>subrayado</u>

#### Asociación



### Diagramas de secuencia

`nombre del objeto : clase a la que pertenece`

* `wally : Robot`: instancia de clase `Robot` que identificamos mediante `wally`

`wally` (sin indicar la clase)

* No indicamos a qué clase pertenece: o no lo sabemos, o consideramos que no es necesario indicarlo. En general, es una falta de información a no ser que sea muy claro.

`: clase`: objeto anónimo

* `: Robot`: no hace falta indicar que nos referimos a uno en concreto.

`clase`

* `Robot`: indicamos que el participante es la clase en sí.

**Multiobjetos:** colecciones de objetos.

* `equipaje: Maleta`: muchas instancias de `Maleta` en un contenedor `equipaje`.
* `: Maleta`: no necesitamos poner nombre.



Ruby `.each` `private_class_method`

self.class.nombreMetodo ejecuta método de clase

selft.nombreMetodo equivale nombreMetodo : ejecuta método de instancia

métodos privados en ruby, instancias y clases



relación entre atributos

~~~ruby
class Prueba
    @duda = 25
    
    def initialize
        @duda = 333
    end
    ...
end
~~~

