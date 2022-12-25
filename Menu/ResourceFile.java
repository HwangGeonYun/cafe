package Menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class ResourceFile {
    private static final int KIND = 0;
    private static final int NAME = 1;
    private static final int BASEPRICE = 2;
    private static final int SIZELIST = 3;

    static String getKind(String[] field){
        return field[KIND];
    }
    static String getName(String[] field){
        return field[NAME];
    }
    static int getBasePrice(String[] field){
        return Integer.valueOf(field[BASEPRICE]);
    }
    static List<String> getSizeList(String[] field){
        return Arrays.stream(field).skip(SIZELIST).map(f->f.replace("\"",  "")).toList();
    }
}
