package items;
import java.util.Objects;
import simulation.*;
import simulation.conditions.*;


public class Dish extends Item implements Clearable{

    private Dirtyness dirtyness;

    public Dish(Dirtyness dirtyness){
        this.dirtyness = dirtyness;
    }

    public void makeClear(){
        this.dirtyness = dirtyness.CLEAR;
    }
    public void makeDirty(){
        this.dirtyness = dirtyness.DIRTY;
    }

    public Dirtyness getDirtyness() {
        return dirtyness;
    }


    @Override
    public String toString() {
        return (getDirtyness()==Dirtyness.DIRTY ? "грязная тарелка " : "чистая тарелка ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return dirtyness == dish.dirtyness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),dirtyness);
    }
}

