public class Carlson extends Human{



    public Carlson(String name){
        super(name);
    }

    @Override
    public int doSmth() {
        Condition cond = getMaxPriorityCond(getCondition());
        switch (cond){
            case HUNGRY:
                return eat(5);
            default:
                return takeRest();
        }



        //System.out.println(getName()+ " что то делает id="+getId());
        //eat(5);
    }



}
