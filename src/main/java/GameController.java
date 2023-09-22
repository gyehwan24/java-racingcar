import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private Cars cars;
    private int carNumber = 0;
    private int gameNumber = 0;

    public void play() throws IOException {
        GameHelper.askCarName();

        List<Name> carNames= Name.createNameList(reader.readLine());
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.cars = new Cars(carList);
        carNumber = cars.getCars().size();

        GameHelper.askGameCount();
        gameNumber = Integer.parseInt(reader.readLine());

        GameHelper.presentationResult();

        for (int i = 0; i < gameNumber; i++) {
            cars.racing();
        }

        cars.showWinners();
    }
}
