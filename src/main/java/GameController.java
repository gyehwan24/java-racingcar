import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 데이터를 입력받고 게임을 진행시킨다.
public class GameController {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Cars cars;
    private int carNumber = 0;
    private int gameNumber = 0;

    // 게임 실행
    public void play() throws IOException {
        GameHelper.askCarName();
        List<CarName> carNames= CarName.createNameList(reader.readLine());
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.cars = new Cars(carList);
        carNumber = cars.getCars().size();

        GameHelper.askGameCount();
        gameNumber = Integer.parseInt(reader.readLine());

        for (int i = 0; i < gameNumber; i++) {
            cars.racing();
        }
        Cars winners = getWinners();
        for (int i = 0; i < winners.getCars().size(); i++) {
            System.out.println(winners.getCars().get(i).getName().getCarName());
        }
        System.out.println();
    }

    public Cars getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> carList = cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
        Cars winners = new Cars(carList);
        return winners;
    }

    public int getMaxPosition() {
        int max = 0;
        for (int i = 0; i < carNumber; i++) {
            max = Math.max(cars.getCars().get(i).getPosition(), max);
        }
        return max;
    }

}
