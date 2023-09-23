import java.util.List;

public class GameView {

    public static void askCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void askGameCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void startGame() {
        System.out.println("실행 결과");
    }

    public static void showProcess(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName().getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void showWinners(Cars cars) {
        List<Car> winners = cars.getWinners();
        if (isOneWinner(winners)) {
            printOneWinner(winners);
            return;
        }
        printManyWinner(winners);
    }

    private static boolean isOneWinner(List<Car> winners) {
        return winners.size() == 1;
    }

    private static void printOneWinner(List<Car> winner) {
        System.out.print(winner.get(0).getName().getCarName());
        endGame();
    }

    private static void printManyWinner(List<Car> winners) {
        for (int i = 0; i < winners.size() - 1; i++) {
            System.out.print(winners.get(i).getName().getCarName() + ", ");
        }
        System.out.print(winners.get(winners.size()-1).getName().getCarName());
        endGame();
    }

    private static void endGame() {
        System.out.println("가 최종 우승했습니다.");
    }
}
