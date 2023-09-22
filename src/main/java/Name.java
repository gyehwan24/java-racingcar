import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Name {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_SPLITTER = ",";

    private String name;

    public Name(String name) {
        this.name = name;
    }

    public static Name createCarName(String name) {
        return new Name(name);
    }

    public static boolean validateNameLength(String name) {
        if (name.length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH) {
            return true;
        }
        throw new IllegalArgumentException("자동차 이름의 길이가 올바르지 않습니다.");
    }

    public String getCarName() {
        return this.name;
    }

    public static List<Name> createNameList(String nameList) {
        String[] splitedNames = nameList.split(NAME_SPLITTER);
        return Arrays.stream(splitedNames)
                .filter(Name::validateNameLength)
                .map(Name::createCarName)
                .collect(Collectors.toList());
    }
}
