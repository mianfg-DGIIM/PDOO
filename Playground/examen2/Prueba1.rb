#encoding:utf-8

module Prueba1

    class Persona
        def andar
            puts "print Persona.andar"
        end

        def hablar
            puts "print Persona.hablar"
        end
    end

    class Profesor < Persona
        def hablar
            puts "print Profesor.hablar"
        end

        def impartir_clase
            puts "print Profesor.impartir_clase"
        end
    end

    Persona.new.andar
    puts Persona.new.hablar
    puts Profesor.new.hablar
    puts Profesor.new.impartir_clase
    puts Profesor.new.andar
    puts Persona.new.impartir_clase

end