import java.util.ArrayList;
import java.util.Arrays;
import simulation.*;
import simulation.conditions.*;
import items.*;
import persons.*;

public class Main {
    public static void main(String[] args) {

        Human carlson = new Carlson("Карлсон");
        Human frecken = new Frecken("Фрекен Бок");
        Human ulius = new Ulius("дядя Юлиус");

        carlson.setCondition(Condition.HUNGRY);
        frecken.setCondition(Condition.HUNGRY);
        ulius.setCondition(Condition.HUNGRY);


        Item[] items = new Item[] {new Towel(Dirtyness.DIRTY),
                new Towel(Dirtyness.DIRTY),
                new Towel(Dirtyness.DIRTY),
                new Dish(Dirtyness.CLEAR),
                new Dish(Dirtyness.CLEAR),
                new Dish(Dirtyness.CLEAR),};
        ItemHolder itemHolder = new ItemHolder(items);
        //itemHolder.printItems();

        Timeline timeline = new Timeline(new Human[] {carlson, frecken, ulius},itemHolder);
        timeline.startSimulation(false);
        //itemHolder.printItems();
        //System.out.println(ulius.getMaxPriorityCond(ulius.getCondition()));
        //System.out.println(items[0]);

    }
}