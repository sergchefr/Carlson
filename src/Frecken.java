public class Frecken extends Human{


    public Frecken(String name) {
        super(name);
    }
    @Override
    public void doSmth(){
        //System.out.println(getName()+ " что то делает id="+getId());
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
    }


}
