public enum Condition{
    HUNGRY(30),
    NEED_TO_SMOKE(27),
    NEED_TO_WASH_DISHES(10),
    NEED_TO_WASH_DISHESHP(50),
    NEED_TO_TOWEL(35),
    NEED_A_REST(0),
    ANGRYHP(26),
    EVEN_MORE_ANGRYHP(27),
    HAPPYHP(25),
    ANGRYLP(0),
    HAPPYLP(0),
    EVEN_MORE_ANGRYLP(0);



    private int priority;
    Condition(int priority) {
        this.priority = priority;
    }
    Condition() {
    }



    public int getPriority() {
        return priority;
    }
}
