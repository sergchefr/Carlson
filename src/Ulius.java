public class Ulius extends Human{


    public Ulius(String name) {
        super(name);
    }

    @Override
    public void doSmth() {
        //System.out.println(getName()+ " что то делает id="+getId());
        Condition cond = getMaxPriorityCond(getCondition());
        switch (cond){
            case HUNGRY:
                eat(4);
                delCondition(Condition.HUNGRY);
                break;
            default:
                takeRest();
                break;

        }
    }
}
