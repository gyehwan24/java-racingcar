import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Name {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name createDefault(String name) {
        validateNameLength(name);
        return new Name(name);
    }

    private static void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 길이가 올바르지 않습니다.");
        }
    }

    public String getCarName() {
        return this.name;
    }
}
