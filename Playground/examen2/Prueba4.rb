#encoding:utf-8

class Padre
    def initialize(b)
        @a=b
        puts "Padre creado, y consigo @a"
    end

    def mostrar_a
        puts "@a es: #{@a}"
    end

    def hola
        puts "¡Hola!"
    end
end

class Hijo < Padre
    def initialize
        @b=4
        puts "Hijo creado, y consigo @b"
    end

    def hola
        puts "¡Helouu!"
    end

end

p = Padre.new(7)
p.hola
p.mostrar_a

h = Hijo.new
h.hola
h.mostrar_a