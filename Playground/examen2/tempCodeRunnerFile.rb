class B < A
    def mostrar_valor
        puts @@valor
    end

    def hola
        puts "Hola i"
    end

    def self.hola
        puts "Hola s"
    end

    def self.mostra
        puts @valor
    end
end

A.new.mostrar
A.new.self.class.mostrar
puts "DONE"
B.new.mostrar_valor
B.hola
B.new.hola