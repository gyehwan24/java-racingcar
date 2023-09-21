public class CarName {

    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String NAME_SPLITTER = ",";
    private String name;

    public CarName(String name) {
        this.name = name;
    }

    // 자동차 이름 길이 검증 메서드
    public static boolean validateNameLength(String name) {
        return name.length() >= MIN_CAR_NAME_LENGTH && name.length() <= MAX_CAR_NAME_LENGTH;
    }

    public String getCarName() {
        return this.name;
    }
}
