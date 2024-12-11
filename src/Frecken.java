public class Frecken extends Human{


    public Frecken(String name) {
        super(name);
    }
    @Override
    public int doSmth() {
        scan(getItemHolder());
        Condition cond = getMaxPriorityCond(getCondition());
        switch (cond){
            case HUNGRY:
                try {
                    return eat(5);
                }catch (NoDishException e){
                    System.out.print(getName()+ " хочет поесть, но чистых тарелок нет, ");
                    delCondition(Condition.ANGRYHP);
                    setCondition(Condition.NEED_TO_WASH_DISHESHP);
                    return 1;
                }

            case NEED_TO_WASH_DISHES:
                return dishwahing(3);
            case NEED_TO_WASH_DISHESHP:
                return dishwahing(3);
            case NEED_TO_TOWEL:
                try{
                    toweling();
                }catch(NoTowelException e){
                    System.out.print(e.getMessage()+" ");
                    delCondition(Condition.HAPPYLP);
                    delCondition(Condition.HAPPYHP);
                    setCondition(Condition.ANGRYHP);
                    anger(1);
                    getTimeline().getMh()[0].takeNewTowels(this,0);
                    try {
                        toweling();
                    }catch (NoTowelException a){
                        setCondition(Condition.EVEN_MORE_ANGRYHP);
                    }
                }
                return 1;
            case HAPPYHP:
                return sing(1);
            case ANGRYHP:
               return anger(1);
            case EVEN_MORE_ANGRYHP:
                return bigAnger(1);

                default:
                return takeRest();

        }

    }
}


