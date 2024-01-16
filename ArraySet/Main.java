package ArraySet;

public class Main {
    public static void main(String[] args) {
        ArraySet <Double> Aset = new ArraySet<Double>();
//        Aset.add(1.0);
//        Aset.add(2.0);
//        Aset.add(3.000);
//        Aset.add(4.0);
//        Aset.add(5.0);
//        Aset.add(6.0);
//        Aset.add(7.0);
//        Aset.add(8.0);
//        Aset.add(9.000);
//        Aset.add(10.0);
//        Aset.add(11.0);
//        Aset.add(12.0);
        for (double i = 0 ; i <20 ; i++ ) {
            Aset.add(i);
        }
        for (double i = Aset.size()-1 ; i >=0 ; i-- ) {
            Aset.delete(i);
        }
        Aset.add(12.0);
        //System.out.println(Aset.find(3.0));
        Aset.display();



    }
}
