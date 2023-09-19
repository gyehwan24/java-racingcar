import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

// 데이터를 입력받고 게임을 진행시킨다.
public class GameController {

    // 입출력
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private List<Car> cars;
    private int carNum = 0;

    // 게임 실행
    public void play() throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
//        cars = reader.readLine();
        System.out.println("시도할 횟수는 몇회인가요?");

    }
}
