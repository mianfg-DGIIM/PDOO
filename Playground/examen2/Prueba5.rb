#encoding:utf-8

module Moduloo

class Padre
    attr_accessor :mc
    def initialize
        @mc = "mi clase"
    end

    protected :mc
end

class Hijo < Padre
    public :mc
end

puts "Creando hijo"
s = Hijo.new
puts s.mc

puts "Creando padre"
c = Padre.new
puts c.mc

end


protected_class_method