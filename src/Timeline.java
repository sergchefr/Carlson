public class Timeline {
    private Human[] mh;
    private int[] duration;


    public Timeline(Human[] mh,ItemHolder itemHolder){                        //конструктор
        this.mh = mh;
        int[] dur = new int[mh.length];
        this.duration = dur;
        for (Human human : mh) {
            human.setItemHolder(itemHolder);
            human.setTimeline(this);
        }
    }


    public void startSimulation(){                          //основной цикл

        int a = 2;//ходы бездействия
        DurationRecord[] rec = new DurationRecord[a];//создание рекордов
        for (int i = 0; i < a; i++) {
            rec[i] = new DurationRecord(new int[mh.length]);
        }

        boolean flag = true;
        int it = 0;
        int recnum = 0;
        while ((any(rec)&true)|flag){//продолжение симуляции, если бездействие продлжается не больше (а) ходов
            flag=false;
            for (int i = 0; i < duration.length; i++) {//те, кто завершил действия, начинают новые
                if (duration[i] == 0) {
                    duration[i] = mh[i].doSmth();
                }
            }
            for (int i = 0; i < duration.length; i++) {//следующий ход
                if (duration[i] > 0) {
                    duration[i] -= 1;
                }
            }
            if (recnum==a) recnum=0;
            rec[recnum] = new DurationRecord(duration.clone());
            recnum += 1;


        }
    }

    private boolean any(DurationRecord[] rec){
        int k=0;
        for (DurationRecord durationRecord : rec) {
            k+= durationRecord.notZero();
        }
        if(k==0){
            //System.out.println("слишком долгое бездействие");
        }
        return (k!=0);
    }

    public Human[] getMh() {
        return mh;
    }

    public void printDurations(){                           //отладка
    for (int i : duration) {
        System.out.print(i+" ");
    }
    System.out.println();
}

    public void printHumans(){
        for (Human i : mh) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    private void printrecords(DurationRecord[] rec){
        for (DurationRecord r : rec) {
            System.out.println("--"+r);
        }
    }

    private void printConditions(){
        for (Human human : mh) {
            human.printConditions();
        }
    }
}

