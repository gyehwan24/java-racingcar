public class Car {

    private static final int START_POSITION = 0;
    private static final int GO_MIN_VALUE = 4;
    private static final int GO_MAX_VALUE = 9;
    private final CarName name;
    private int position;

    public Car(CarName name) {
        this.name = name;
        this.position = START_POSITION;
    }

    // 한 칸 전진, 멈추는 경우는 아무 메서드도 실행하지 않는다.
    public void go() {
        this.position++;
    }

    // 주사위 결과에 따라 자동차가 전진하는지 체크
    public boolean validateGO(int number) {
        return GO_MIN_VALUE <= number && number <= GO_MAX_VALUE;
    }

    // 주사위 결과에 따라서 전진하거나 멈추고, 결과를 출력한다.
    public void racing(int dice) {
        if (validateGO(dice)) {
            this.go();
        }
        this.printStatus();
    }

    // 자동차의 현재 상태 출력(이름, 포지션)
    public void printStatus() {
        System.out.println(this.name + " : " + printPosition(this.position));
    }

    // 현재 위치만큼 '-' 출력
    public String printPosition(int position) {
        String prettyPosition = "";
        for (int i = 0; i < position; i++) {
            prettyPosition += "-";
        }
        return prettyPosition;
    }
}
