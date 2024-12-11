import java.util.ArrayList;
import java.util.Objects;

public abstract class Human implements HumanActivities{
    private String name;
    private ArrayList<Condition> condition= new ArrayList<>();
    private boolean printDur;

    private int id;
    private static int nextid=0;

    private ItemHolder itemHolder;
    private Timeline timeline;

    {
        condition.add(Condition.NEED_A_REST);
    }

    public Human(String name) {
        this.name = name;
        this.printDur = printDur;
        id = nextid;
        nextid++;
    }
    public abstract int doSmth();

    public int priority(Condition cond){
        return cond.getPriority();
    }

    public Condition getMaxPriorityCond(ArrayList<Condition> cond){
        Condition a=cond.get(0);
        for (Condition a1 : cond) {
            //System.out.println(a1+" "+ priority(a1));
            if (priority(a1)>priority(a)){ a = a1;}
        }
        return a;
    }


    public void scan(ItemHolder itemHolder){
        for (Item item : itemHolder.getItems()) {
            if (item.getClass()==Dish.class) {
                if(((Dish) item).getDirtyness()==Dirtyness.DIRTY){
                    setCondition(Condition.NEED_TO_WASH_DISHES);
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return id == human.id && Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }



    public ArrayList<Condition> getCondition() {
        return condition;
    }
    public void setCondition(Condition cond) {
        if (!condition.contains(cond)){
            condition.add(cond);
        }
    }
    public void delCondition(Condition cond) {
        if (condition.contains(cond)){
            condition.remove(cond);
        }
    }
    public void printConditions(){
        for (Condition cond : condition) {
            System.out.println(name + " " + cond);
        }
    }

    public boolean getPrintDur(){
        return printDur;
    }

    public void setPrintDur(boolean printDur) {
        this.printDur = printDur;
    }

    public void setItemHolder(ItemHolder itemHolder){
        this.itemHolder=itemHolder;
    }
    public ItemHolder getItemHolder() {
        return itemHolder;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }
}
