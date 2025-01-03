package core.basesyntax.services.impl;

import core.basesyntax.services.FileDataWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class FileDataWriterImpl implements FileDataWriter {
    private final Path newPath;

    public FileDataWriterImpl(Path newPath) {
        this.newPath = newPath;
    }

    @Override
    public File writeData(List<String> processedList) {
        File file = new File(String.valueOf(newPath));
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (String string : processedList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not write data to a file" + file.getName(), e);
        }
        return file;
    }
}
