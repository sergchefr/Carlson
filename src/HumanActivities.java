public interface HumanActivities {
    void delCondition(Condition cond);
    void setCondition(Condition cond);
    String getName();
    ItemHolder getItemHolder();
    boolean getPrintDur();




    default int sing(int minutes){
        System.out.print( getName()+ " поет"+(getPrintDur()? " "+minutes+" мин., ": ", "));
        delCondition(Condition.HAPPYHP);
        setCondition(Condition.HAPPYLP);
        return minutes;
    }

    default int anger(int minutes){
        System.out.print(getName() + " злится"+(getPrintDur()? " "+minutes+" мин., ": ", "));
        delCondition(Condition.ANGRYHP);
        setCondition(Condition.ANGRYLP);
        return minutes;
    }

    default int bigAnger(int minutes){
        System.out.print(getName() + " злится еще сильнее"+(getPrintDur()? " "+minutes+" мин., ": ", "));
        delCondition(Condition.EVEN_MORE_ANGRYHP);
        setCondition(Condition.EVEN_MORE_ANGRYLP);
        return minutes;
    }

    default int takeNewTowels(Human forwho,int minutes){
        Dirtyness a  = (Math.random()>0.5? Dirtyness.CLEAR:Dirtyness.DIRTY);
        getItemHolder().addItems(new Towel(a));
        System.out.print(getName() + " приносит "+ (a==Dirtyness.DIRTY?"грязное":"чистое")+" полотенце ");
        if (a==Dirtyness.DIRTY){
            forwho.setCondition(Condition.EVEN_MORE_ANGRYHP);
        }else{
            forwho.delCondition(Condition.EVEN_MORE_ANGRYHP);
            forwho.delCondition(Condition.EVEN_MORE_ANGRYLP);
            forwho.delCondition(Condition.ANGRYHP);
            forwho.delCondition(Condition.ANGRYLP);
            System.out.print(forwho.getName()+" успокаивается ");
        }

        return minutes;
    }

    default int eat(int minutes)throws NoDishException{
        for (Item it: getItemHolder().getItems()) {
            if(it.getClass()==Dish.class){
                if(((Dish) it).getDirtyness()==Dirtyness.CLEAR){
                    System.out.print(getName() + " ест"+(getPrintDur()? " "+minutes+" мин., ": ", "));
                    delCondition(Condition.HUNGRY);
                    setCondition(Condition.HAPPYHP);
                    ((Dish) it).makeDirty();
                    return minutes;
                }
            }
        }
        setCondition(Condition.ANGRYHP);
        throw new NoDishException("нет чистых тарелок");
    }

    default int smoke(int minutes){
        System.out.print(getName() + " курит"+(getPrintDur()? " "+minutes+" мин., ": ", "));
        delCondition(Condition.NEED_TO_SMOKE);
        delCondition(Condition.ANGRYHP);
        delCondition(Condition.ANGRYLP);
        setCondition(Condition.HAPPYHP);
        return minutes;
    }

    default int takeRest(){
        //System.out.print(name + " отдыхает ");
        return 0;
    }

    default int sleep(int minutes){
        System.out.print(getName()+" спит"+(getPrintDur()? " "+minutes+" мин., ": ", "));
        return minutes;
    }
    default int dishwahing(int minutes){
        delCondition(Condition.NEED_TO_WASH_DISHES);
        for (Item item : getItemHolder().getItems()) {
            if (item.getClass()==Dish.class){
                if(((Dish) item).getDirtyness()==Dirtyness.DIRTY){
                    ((Dish) item).makeClear();
                    setCondition(Condition.NEED_TO_TOWEL);
                    delCondition(Condition.NEED_TO_WASH_DISHESHP);
                    System.out.print(getName() + " моет тарелку"+(getPrintDur()? " "+minutes+" мин., ": ", "));
                    return minutes;
                }
            }
        }
        return 0;
    }

    default int toweling() throws NoTowelException{
        for (Item item : getItemHolder().getItems()) {
            if (item.getClass()==Towel.class){
                if(((Towel) item).getDirtyness()==Dirtyness.CLEAR){
                    delCondition(Condition.NEED_TO_TOWEL);
                    //((Towel) item).makeDirty();                       //возможно лишнее
                    System.out.print(getName() + " вытирает руки ");
                    return 0;
                }
            }
        }
        throw new NoTowelException(getName()+" не может найти полотенце");
    }


}
