package core.basesyntax.dao;

import java.nio.file.Path;
import java.util.List;

public interface FileDataReader {
    List<String> readData(Path path);
}