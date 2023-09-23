import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void racing() {
        this.cars.forEach(Car::racing);
        System.out.println();
    }

    private int getMaxPosition() {
        int max = 0;
        for (Car car : this.cars) {
            max = Math.max(car.getPosition(), max);
        }
        return max;
    }

    private List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
        return winners;
    }


    public void showWinners() {
        List<Car> winners = this.getWinners();
        for (Car winner : winners) {
            System.out.print(winner.getName().getCarName() + " ");
        }
        System.out.println("가 최종 우승했습니다.");
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
