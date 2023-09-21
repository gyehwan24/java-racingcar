import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void racing() {
        this.cars.forEach(Car::racing);
        System.out.println();
    }

    // 자동차 중 가장 많은 거리를 움직인 자동차의 포지션을 구하는 메서드
    public int getMaxPosition() {
        int max = 0;
        for (Car car : this.cars) {
            max = Math.max(car.getPosition(), max);
        }
        return max;
    }

    // 우승자를 찾는 메서드
    public Cars getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> carList = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
        Cars winners = new Cars(carList);
        return winners;
    }


    // 우승자를 출력하는 메서드
    public void showWinners() {
        Cars winners = this.getWinners();
        for (int i = 0; i < winners.getCars().size(); i++) {
            System.out.print(winners.getCars().get(i).getName().getCarName()+" ");
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
