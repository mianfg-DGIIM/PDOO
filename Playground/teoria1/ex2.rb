class Test
    def initialize(a)
    @atributo=a
    end
    attr_reader :atributo
    public
    def copiaAtributo(otro)
    @atributo=otro.atributo
    end
    def to_s
    @atributo.to_s
    end
    end
    t1=Test.new(333)
    t2=Test.new(444)
    puts t1.to_s
    puts t2.to_s
    t1.copiaAtributo(t2)
    puts t1.to_s
    puts t2.to_s
    