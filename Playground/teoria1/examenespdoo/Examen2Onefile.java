class Father {
    void porDefecto() {
        System.out.println("Por defecto");
    }
    private void privado() {
        System.out.println("Privado");
    }
    protected void protegido() {
        System.out.println("Protegido");
    }
    public void publico() {
        System.out.println("Publico");
    }
    public void usa(Father f){
        f.porDefecto();
        f.privado();
        f.protegido();
        f.publico();
    }
}

class Son extends Father {
    void prueba() {
        porDefecto();
//        privado();
        protegido();
        publico();        
}
    @Override
    public void usa(Father f){
        f.porDefecto();
//        f.privado();
        f.protegido();
        f.publico();
    }
    
}


public class Examen2Onefile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Father f1=new Father();
        Father f2=new Father();
        Son s=new Son();
        
        f1.porDefecto();
//        f1.privado();
        f1.protegido();
        f1.publico();
        System.out.println("-----");
        f1.usa(f2);
        System.out.println("-----");      
        s.prueba();        
        System.out.println("-----");      
        s.usa(f1);
        
    }        
} 
