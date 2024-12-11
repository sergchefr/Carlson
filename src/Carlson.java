public class Carlson extends Human{



    public Carlson(String name){
        super(name);
    }

    @Override
    public void doSmth() {
        Condition cond = getMaxPriorityCond(getCondition());
        switch (cond){
            case HUNGRY:
                eat(5);
                delCondition(Condition.HUNGRY);
                break;
            default:
                takeRest();
                break;

        }



        //System.out.println(getName()+ " что то делает id="+getId());
        //eat(5);
    }



}
