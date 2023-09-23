public class Car {

    private static final int START_POSITION = 0;
    private static final int GO_MIN_VALUE = 4;
    private static final int GO_MAX_VALUE = 9;

    private final Name name;
    private int position;

    private Car(Name name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public static Car createDefault(Name name) {
        return new Car(name);
    }

    private void go() {
        this.position++;
    }

    private boolean canGo(int number) {
        return GO_MIN_VALUE <= number && number <= GO_MAX_VALUE;
    }

    public void racing() {
        NumGenerator numGenerator = new NumGenerator();
        if (canGo(numGenerator.getNumber())) {
            this.go();
        }
        this.printStatus();
    }

    private void printStatus() {
        System.out.println(this.name.getCarName() + " : " + printPosition(this.position));
    }

    private String printPosition(int position) {
        String prettyPosition = "";
        for (int i = 0; i < position; i++) {
            prettyPosition += "-";
        }
        return prettyPosition;
    }

    public int getPosition() {
        return this.position;
    }

    public Name getName() {
        return this.name;
    }
}
