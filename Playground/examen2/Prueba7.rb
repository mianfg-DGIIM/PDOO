#encoding:utf-8

class Papi 
    private
    def privado
        puts "Privado!"
    end

    protected
    def protegido
        puts "Protegido!"
    end

    def self.protegido
        puts "Protegido? (pero de clase)"
    end

    public
    def publico
        puts "Publico!"
    end

    def test(p)
        privado #correcto: no tiene receptor
        protegido #correcto: misma clase, desde instancia
        self.protegido #correcto: misma clase, desde instancia
        p.protegido #correcto: llamado desde instancia de misma clase, en método de instancia
    end

    def self.test(p)
        #p.privado #incorrecto: tiene receptor
        #p.protegido #incorrecto: debe llamarse desde ámbito de instancia
    end

    Papi.protegido #okay: el método de clase no se hace protected

    q=Papi.new
    #q.protegido #no se puede llamar desde ámbito de clase
end

puts "1"
Papi.new.test(Papi.new)
puts "2"
Papi.test(Papi.new)
p=Papi.new
#p.privado
#p.protegido #debe ser en ámbito de clase
p.publico

class Hija < Papi
    private
    def privado_h
        puts "H Privado!"
    end

    protected
    def protegido_h
        puts "H Protegido!"
    end

    def self.protegido_h
        puts "H Protegido? (pero de clase)"
    end

    public
    def publico_h
        puts "H Publico!"
    end

    def test(p)
        privado
        protegido
        self.protegido
        p.protegido
        publico
        self.publico
        p.publico
    end

    def test2(p)
        privado_h
        protegido_h
        self.protegido_h
        #p.protegido_h #da fallo al llamarlo con p=instancia de Padre -> no lo tiene!
        publico_h
        self.publico_h
        #p.publico_h #ídem anterior
    end
end

puts "Ahora pasamos a Hija"
puts "1"
Hija.new.test(Hija.new)
puts "2"
Hija.new.test(Papi.new)
puts "3"
h=Hija.new
#h.privado
#h.protegido
h.publico

puts "Ahora otra vez Papi"
Hija.new.test2(Papi.new)