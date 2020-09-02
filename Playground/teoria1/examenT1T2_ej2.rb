class A
    def initialize
        @atributo=1
    end
    attr_accessor :atributo
end
class B
    def initialize
        @atributo=2
    end
    attr_accessor :atributo
end
class C
    def initialize(a)
        @atributo=a
    end
    attr_accessor :atributo    
end

class Test
    @@a=A.new
    @b=B.new
    def self.a
        @a
    end
    def self.a=(aa)
        @a =aa
    end
    def self.b
        @b
    end
    def self.b=(i)
        @b.atributo = i
    end
    def initialize
        @c=C.new(99)
    end
    def to_s
        @@a.atributo.to_s+" "+
        self.class.b.atributo.to_s+" " + @c.atributo.to_s
    end
    def modifica
        @@a.atributo=11
        @c.atributo=33
    end
    def modifica2
        @@a.atributo=111
        @c.atributo=333
    end
end

t1=Test.new         #OK
t2=Test.new         #OK
t3=t1               #OK
puts t1.to_s        #1 2 99
puts t2.to_s        #1 2 99
puts t3.to_s        #1 2 99
t1.modifica         #OK
puts t1.to_s        #11 2 33
puts t2.to_s        #1 2 99         CUIDADO porque a, b son DE CLASE 11 2 99
puts t3.to_s        #11 2 33
t2.modifica2        #111 2 333
puts t1.to_s        #11 2 33
puts t2.to_s        #111 2 333
puts t3.to_s        #11 2 33        111 2 33
t2.class.b = 4
puts t2.to_s
t2.class.a = A.new
puts t2.to_s