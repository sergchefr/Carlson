public class Carlson extends Human{



    public Carlson(String name){
        super(name);
    }

    @Override
    public int doSmth() {
        Condition cond = getMaxPriorityCond(getCondition());
        switch (cond){
            case HUNGRY:
                try {
                    return eat(5);
                }catch (NoDishException e){
                    System.out.print(getName()+ " хочет поесть, но чистых тарелок нет, ");
                    return 0;
                }

            default:
                return takeRest();
        }



        //System.out.println(getName()+ " что то делает id="+getId());
        //eat(5);
    }



}
