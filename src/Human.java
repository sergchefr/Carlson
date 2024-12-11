import java.util.ArrayList;
import java.util.Objects;

public abstract class Human {
    private String name;
    private ArrayList<Condition> condition= new ArrayList<>();

    private int id;
    private static int nextid=0;

    private Timeline timeline;



    public Human(String name) {
        this.name = name;
        id = nextid;
        nextid++;

    }
    public abstract void doSmth();

    public int priority(Condition cond){
        return Condition.HUNGRY.getPriority();
    }

    public Condition getMaxPriorityCond(ArrayList<Condition> cond){
        Condition a= cond.get(0);
        for (Condition a1 : cond) {
            if (priority(a1)>priority(a)) a = a1;
        }
        return a;
    }



    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }
    public Timeline getTimeline() {
        return timeline;
    }



    public void eat(int minutes){
        System.out.println(name + " ест "+minutes+" минут");
        getTimeline().setDuration(this,minutes);
    }

    public void takeRest(){
        System.out.println(name + " отдыхает");
    }

    public void sleep(){
        System.out.println(name+" спит");
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
}
