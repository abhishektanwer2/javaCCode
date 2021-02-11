package interfaceexample;

public class hondaciviccar {
    private final fourWheeler fourWheeler;
    private  final car car;

    public hondaciviccar(interfaceexample.fourWheeler fourWheeler, interfaceexample.car car) {
        this.fourWheeler = fourWheeler;
        this.car = car;
    }
    public String newdrive(){
        System.out.println(car.accelerate());
        System.out.println(fourWheeler.brake());
        System.out.println(fourWheeler.getPetrolInfo());
      return  fourWheeler.getSpeed();
    }
}
