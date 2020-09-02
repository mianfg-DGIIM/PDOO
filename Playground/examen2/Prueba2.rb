#encoding:utf-8

# PRUEBA
# Privado y público en Ruby

class Ejemplo
    
    def self.habla
        puts "HABLO"
    end

    def metodo_publico(ej)
        self.class.habla
        #self.class.metodoc_privado
        metodo_privado #OK
        #self.class.metodoc_privado
        #ej.class.metodoc_privado
        puts "_______\n\n"
        #NOOOOOOOej.metodo_privado #
    end

    def metodo_privado
        puts "Has llamado a método privado"
    end

    def metodo_privado2
        puts "Has llamado a método privado 2"
    end
    
    def self.metodoc_yaaa
        metodoc_privado
    end

    def self.metodoc_privado    # ¿Cómo puede ser accesible? -> DESDE UN MÉTODO DE CLASE
        puts "Has llamado a métodoc privado"
    end

    metodoc_privado # puedo hacerlo aquí

    private :metodo_privado, :metodo_privado2
    private_class_method :metodoc_privado
end

Ejemplo.new.metodo_publico(Ejemplo.new)
#Ejemplo.metodoc_privado
Ejemplo.metodoc_yaaa