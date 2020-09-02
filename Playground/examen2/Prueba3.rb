#encoding:utf-8

# PRUEBA super

class Padre
    def hola
        nombre = "María"
        puts "Hola, #{nombre}"
    end
end

class Hijo < Padre
    def hola(nombre)
        super()
        super()
        super
    end
end

Padre.new.hola
Hijo.new.hola("Antonia")