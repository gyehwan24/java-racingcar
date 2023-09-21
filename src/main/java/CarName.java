import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarName {

    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String NAME_SPLITTER = ",";
    private String name;

    public CarName(String name) {
        this.name = name;
    }

    public static CarName createCarName(String name) {
        return new CarName(name);
    }

    // 자동차 이름 길이 검증 메서드
    public static boolean validateNameLength(String name) {
        return name.length() >= MIN_CAR_NAME_LENGTH && name.length() <= MAX_CAR_NAME_LENGTH;
    }

    public String getCarName() {
        return this.name;
    }

    // 자동차들의 이름 문자열 받아서 , 단위로 쪼개고 리스트로 생성
    public static List<CarName> createNameList(String nameList) {
        String[] splitedNames = nameList.split(NAME_SPLITTER);
        return Arrays.stream(splitedNames)
                .filter(CarName::validateNameLength)
                .map(CarName::createCarName)
                .collect(Collectors.toList());
    }
}
