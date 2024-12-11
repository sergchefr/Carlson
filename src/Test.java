public class Test {
    public void test(){
        int[] mh = {1,2,3};
        int a = 5;//ходы бездействия
        DurationRecord[] rec = new DurationRecord[a];//создание рекордов
        for (int i = 0; i < a; i++) {
            rec[i] = new DurationRecord(new int[mh.length]);
        }

        printRec(rec);

//        rec[1] = new DurationRecord(new int[]{1,2,5});
//        printRec(rec);
//        rec[0] = new DurationRecord(new int[]{3,4,5});
//        printRec(rec);
        for (int i = 0; i < a; i++) {
            rec[i] = new DurationRecord(new int[]{i,i+1,i+2});
        }
        printRec(rec);

    }



    private void printRec(DurationRecord[] rec){
        for (DurationRecord durationRecord : rec) {
            System.out.println(durationRecord);
        }
        System.out.println();
    }
}
