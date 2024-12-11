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
        return "Towel{" +
                "dirtyness=" + dirtyness +
                '}';
    }

    public Dirtyness getDirtyness() {
        return dirtyness;
    }
}
