import java.util.ArrayList;
import java.util.Objects;

public abstract class Human {
    private String name;
    private ArrayList<Condition> condition= new ArrayList<>();

    private int id;
    private static int nextid=0;

    private ItemHolder itemHolder;
    private Timeline timeline;



    public Human(String name) {
        this.name = name;
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

    public int sing(int minutes){
        System.out.print(name + " поет "+minutes+" минут ");
        delCondition(Condition.HAPPYHP);
        setCondition(Condition.HAPPYLP);
        return minutes;
    }

    public int anger(int minutes){
        System.out.print(name + " злится "+minutes+" минут ");
        delCondition(Condition.ANGRYHP);
        setCondition(Condition.ANGRYLP);
        return minutes;
    }

    public int bigAnger(int minutes){
        System.out.print(name + " злится еще сильнее "+minutes+" минут ");
        delCondition(Condition.EVEN_MORE_ANGRYHP);
        setCondition(Condition.EVEN_MORE_ANGRYLP);
        return minutes;
    }

    public int takeNewTowels(Human forwho,int minutes){
        Dirtyness a  = (Math.random()>0.5? Dirtyness.CLEAR:Dirtyness.DIRTY);
        getItemHolder().addItems(new Towel(a));
        System.out.print(name + " приносит "+ (a==Dirtyness.DIRTY?"грязное":"чистое")+" полотенце ");
        if (a==Dirtyness.DIRTY){
            forwho.setCondition(Condition.EVEN_MORE_ANGRYHP);
        }else{
            forwho.delCondition(Condition.EVEN_MORE_ANGRYHP);
            forwho.delCondition(Condition.EVEN_MORE_ANGRYLP);
            forwho.delCondition(Condition.ANGRYHP);
            forwho.delCondition(Condition.ANGRYLP);
            System.out.print(forwho.getName()+" успокаивается ");
        }

        return minutes;
    }



    public int eat(int minutes){
        System.out.print(name + " ест "+minutes+" минут ");
        delCondition(Condition.HUNGRY);
        setCondition(Condition.HAPPYHP);
        return minutes;
    }

    public int smoke(int minutes){
        System.out.print(name + " курит "+minutes+" минут ");
        delCondition(Condition.NEED_TO_SMOKE);
        return minutes;
    }

    public int takeRest(){
        //System.out.print(name + " отдыхает ");
        return 0;
    }

    public int sleep(int minutes){
        System.out.print(name+" спит ");
        return minutes;
    }
    public int dishwahing(int minutes){
        delCondition(Condition.NEED_TO_WASH_DISHES);
        for (Item item : itemHolder.getItems()) {
            if (item.getClass()==Dish.class){
                if(((Dish) item).getDirtyness()==Dirtyness.DIRTY){
                    ((Dish) item).makeClear();
                    setCondition(Condition.NEED_TO_TOWEL);
                    System.out.print(name + " моет тарелку "+minutes+" минут ");
                    return minutes;
                }
            }
        }
        return 0;
    }

    public int toweling() throws NoTowelException{
        for (Item item : itemHolder.getItems()) {
            if (item.getClass()==Towel.class){
                if(((Towel) item).getDirtyness()==Dirtyness.CLEAR){
                    delCondition(Condition.NEED_TO_TOWEL);
                    System.out.print(name + " вытирает руки ");
                    return 0;
                }
            }
        }
        throw new NoTowelException(name+" не может найти полотенце");
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
