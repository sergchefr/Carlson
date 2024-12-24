package simulation;
import java.util.Arrays;

public record DurationRecord(int[] duration) {
    public int notZero(){
        int k=0;
        for (int i : duration) {
            k+=i;
        }
        return (k!=0 ? 1 : 0);
    }

    @Override
    public String toString() {
        String k = "";
        for (int i : duration) {
            k+=i+" ";
        }
        return k;
    }
}
