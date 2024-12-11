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
}

