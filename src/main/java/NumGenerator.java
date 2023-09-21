import java.util.Random;

public class NumGenerator {

    private static final int NUMBER_MAX_VALUE = 10;
    private int number;

    Random random = new Random();

    public NumGenerator() {
        this.number = random.nextInt(NUMBER_MAX_VALUE);
    }

    public int getNumber() {
        return this.number;
    }
}
