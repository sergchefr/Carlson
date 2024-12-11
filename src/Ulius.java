public class Ulius extends Human{
    public Ulius(String name) {
        super(name);

    }

    @Override
    public int doSmth() {
        //System.out.println(getName()+ " что то делает id="+getId());
        Condition cond = getMaxPriorityCond(getCondition());
        //System.out.println(getName()+" "+cond);
        switch (cond){
            case HUNGRY:
                setCondition(Condition.NEED_TO_SMOKE);
                return eat(5);

            case NEED_TO_SMOKE:
                return smoke(3);
            case HAPPYHP:
                System.out.print(getName()+ " довольный, ");
                delCondition(Condition.HAPPYHP);
                setCondition(Condition.HAPPYLP);
            default:
                return takeRest();
        }
    }
}
