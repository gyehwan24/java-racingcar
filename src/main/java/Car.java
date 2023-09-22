public class Car {

    private static final int START_POSITION = 0;
    private static final int GO_MIN_VALUE = 4;
    private static final int GO_MAX_VALUE = 9;

    private final Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public void go() {
        this.position++;
    }

    public boolean validateGO(int number) {
        return GO_MIN_VALUE <= number && number <= GO_MAX_VALUE;
    }

    public void racing() {
        NumGenerator numGenerator = new NumGenerator();
        if (validateGO(numGenerator.getNumber())) {
            this.go();
        }
        this.printStatus();
    }

    public void printStatus() {
        System.out.println(this.name.getCarName() + " : " + printPosition(this.position));
    }

    public String printPosition(int position) {
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
