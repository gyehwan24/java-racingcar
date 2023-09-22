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

    private Cars getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> carList = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
        Cars winners = new Cars(carList);
        return winners;
    }


    public void showWinners() {
        Cars winners = this.getWinners();
        for (int i = 0; i < winners.getCars().size(); i++) {
            System.out.print(winners.getCars().get(i).getName().getCarName()+" ");
        }
        System.out.println("가 최종 우승했습니다.");
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
