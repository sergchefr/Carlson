public class Timeline {
    private Human[] mh;
    private int[] duration;


    public Timeline(Human[] mh){                        //конструктор
        this.mh = mh;
        int[] dur = new int[mh.length];
        this.duration = dur;
        for (Human human : mh) {
            human.setTimeline(this);
        }
    }


    public void startSimulation(){                          //основной цикл

        int a = 5;//ходы бездействия
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
                    mh[i].doSmth();
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
            //printDurations();
            //printrecords(rec);


        }
    }


    public void setDuration(Human h, int dur){          //установка длительности хода
        for (int i = 0; i < duration.length; i++) {
            if(mh[i].equals(h)){
                duration[i]=dur;
                //System.out.println("hell yea");
                break;
            }
        }
        //printDurations();
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

    private boolean any(DurationRecord[] rec){
        int k=0;
        for (DurationRecord durationRecord : rec) {
            //System.out.println("--"+durationRecord);
            k+= durationRecord.notZero();
        }
        //System.out.println("??"+k+"??"+(k!=0));
        //System.out.println("");
        if(k==0){
            System.out.println("слишком долгое бездействие");
        }
        return (k!=0);
    }

    private void printrecords(DurationRecord[] rec){
        for (DurationRecord r : rec) {
            System.out.println("--"+r);
        }
    }
}

