public enum Condition{
    HUNGRY(30),
    NEED_TO_SMOKE(20),
    NEED_TO_WASH_DISHES(10),
    NEED_TO_TOWEL(40),
    NEED_A_REST(0);



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
