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
        ulius.setCondition(Condition.NEED_A_REST);
        Timeline timeline = new Timeline(new Human[] {carlson, frecken, ulius});
        //timeline.printHumans();
        //timeline.printDurations();
        //timeline.setDuration(frecken, 7);
        //timeline.setDuration(carlson, 3);
        //timeline.setDuration(ulius, 5);
        timeline.startSimulation();
        Test test = new Test();
        //test.test();
        System.out.println(Condition.HUNGRY.getPriority());


    }
}