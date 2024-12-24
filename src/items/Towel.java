package items;
import java.util.Objects;
import simulation.*;
import simulation.conditions.*;

public class Towel extends Item implements Clearable{
    private Dirtyness dirtyness;

    public Towel(Dirtyness dirtyness){
        this.dirtyness = dirtyness;
    }

    public void makeClear(){
        this.dirtyness = dirtyness.CLEAR;
    }
    public void makeDirty(){
        this.dirtyness = dirtyness.DIRTY;
    }


    @Override
    public String toString() {
        return (getDirtyness()==Dirtyness.DIRTY ? "грязное полотенце " : "чистое полотенце ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Towel towel = (Towel) o;
        return dirtyness == towel.dirtyness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),dirtyness);
    }

    public Dirtyness getDirtyness() {
        return dirtyness;
    }
}
