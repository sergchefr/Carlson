package simulation;
import java.util.Objects;
public abstract class Item {
    private int id;
    private static int nextid=0;

    public Item(){
        id = nextid;
        nextid++;
    }

    public int getId(){
        return id;
    }
}
