import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

// 데이터를 입력받고 게임을 진행시킨다.
public class GameController {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Cars cars;
    private int carNum = 0;
    private int gameNumber = 0;

    // 게임 실행
    public void play() throws IOException {
        GameHelper.askCarName();
        List<CarName> carNames= CarName.createNameList(reader.readLine());
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.cars = new Cars(carList);

        GameHelper.askGameCount();
        gameNumber = Integer.parseInt(reader.readLine());

        for (int i = 0; i < gameNumber; i++) {
            cars.racing();
        }



    }
}
