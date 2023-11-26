import java.util.ArrayList;
import java.util.Iterator;

public class Primi implements Iterator<Integer> {
    // OVERVIEW: Iterator che genera numeri primi

    // attributes
    private ArrayList<Integer> primi = new ArrayList<Integer>();
    private int current;

    // constructor
    public Primi() {
        // MODIFIES: this
        // EFFECTS: inizializza this
        this.primi = new ArrayList<Integer>();
        this.current = 2;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        // MOFIFIES: this.current
        boolean isPrime = true;
        for (Integer divisore : this.primi) {
            if (this.current % divisore == 0) {
                isPrime = false;
            }
        }
        if (isPrime) {
            return this.current;
        } else {
            this.current++;
            return this.next();
        }
    }

    public static void main(String[] args) {
        Primi p = new Primi();
        int n = Integer.parseInt(args[0]);
        while (p.primi.size() < n) {
            p.primi.add(p.next());
            System.out.println(p.current);
        }
    }

}
