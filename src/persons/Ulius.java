package persons;
import simulation.*;
import simulation.conditions.*;
import simulation.exceptions.*;

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
                try {
                    return eat(5);
                }catch (NoDishException e){
                    System.out.print(getName()+ " хочет поесть, но чистых тарелок нет, ");
                    return 0;
                }


            case NEED_TO_SMOKE:
                return smoke(3);
            case ANGRYHP:
                setCondition(Condition.NEED_TO_SMOKE);
                return 0;
            case HAPPYHP:
                System.out.print(getName()+ " довольный, ");
                delCondition(Condition.HAPPYHP);
                setCondition(Condition.HAPPYLP);
                return 0;
            default:
                return takeRest();
        }
    }
}
