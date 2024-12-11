import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Human carlson = new Carlson("Карлсон");
        Human frecken = new Frecken("Фрекен Бок");
        Human ulius = new Ulius("дядя Юлиус");

        carlson.setCondition(Condition.HUNGRY);
        frecken.setCondition(Condition.HUNGRY);
        ulius.setCondition(Condition.HUNGRY);
        carlson.setCondition(Condition.NEED_A_REST);
        frecken.setCondition(Condition.NEED_A_REST);
        //frecken.setCondition(Condition.NEED_TO_WASH_DISHES);
        ulius.setCondition(Condition.NEED_A_REST);


        Item[] items = new Item[] {new Towel(Dirtyness.DIRTY),new Towel(Dirtyness.DIRTY),new Towel(Dirtyness.DIRTY),new Dish(Dirtyness.DIRTY),new Dish(Dirtyness.DIRTY),new Dish(Dirtyness.CLEAR),};
        ItemHolder itemHolder = new ItemHolder(items);
        //itemHolder.printItems();
        //frecken.printConditions();
        //System.out.println(itemHolder.getItems().get(0).getClass()==Dish.class);

        Timeline timeline = new Timeline(new Human[] {carlson, frecken, ulius},itemHolder);
        timeline.startSimulation();
        //itemHolder.printItems();
        //frecken.printConditions();
    }
}