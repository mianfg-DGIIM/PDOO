class Father
  def publico()
    puts "Publico-father"
  end
  def usa(f)
#    f.privado()     
    f.protegido   
    f.publico()
  end
  private
  def privado()
    puts "Privado-father"
  end
  protected
  def protegido()
    puts "Protegido-father"
  end
end


class Son < Father
  def prueba()
    privado    
    protegido    
    publico
  end
  
  def usa(f)
#    f.privado()     
    f.protegido   
    f.publico()    
  end
  
end


f1=Father.new
f2=Father.new
s=Son.new

#f1.privado
#f1.protegido
f1.publico
puts "------"
f1.usa(f2)
puts "-----"
s.prueba
puts "-----"
s.usa(f1)
