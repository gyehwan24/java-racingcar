import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameController {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private Cars cars;
    private int carNumber = 0;
    private int gameNumber = 0;

    public void play() throws IOException {
        GameView.askCarName();

        String names = reader.readLine();
        Cars cars = Cars.createDefault(names);

        carNumber = cars.getCars().size();

        GameView.askGameCount();
        gameNumber = Integer.parseInt(reader.readLine());

        GameView.startGame();

        for (int i = 0; i < gameNumber; i++) {
            cars.racing();
            GameView.showProcess(cars);
        }

        GameView.showWinners(cars);
    }
}
