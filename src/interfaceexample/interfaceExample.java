package interfaceexample;

public class interfaceExample {

    public static void main(String[]args){
        hondaciviccar honda=new hondaciviccar(new hondCivic(), new hondCivic());
        System.out.println(honda.newdrive());
    }
}
