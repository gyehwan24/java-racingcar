import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String NAME_SPLITTER = ",";

    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createDefault(String names) {
        List<Name> splitName = Cars.createNameList(names);
        List<Car> cars = new ArrayList<>();
        for (Name name : splitName) {
            cars.add(Car.createDefault(name));
        }
        return new Cars(cars);
    }

    public void racing() {
        this.cars.forEach(Car::racing);
    }

    private int getMaxPosition() {
        int max = 0;
        for (Car car : this.cars) {
            max = Math.max(car.getPosition(), max);
        }
        return max;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }


    private static List<Name> createNameList(String names) {
        String[] splitnames = names.split(NAME_SPLITTER);
        return Arrays.stream(splitnames)
                .map(Name::createDefault)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
