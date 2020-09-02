#encoding:utf-8

#PRUEBA Herencia de atributos

class C1
    @@valor = 14
    @valor = 16

    def mostrar
        puts @@valor
    end

    def self.mostrar
        puts "MOSTRARR::"
        puts @valor
    end
end

class C2 < C1
    @@valor -=1
    def self.modifica
        @@valor -= 1
    end

    
end

uno = C1.new
dos = C2.new
C2.modifica
dos.mostrar
uno.mostrar
tres = C2.new
tres.mostrar
tres.class.modifica
dos.mostrar
C2.mostrar