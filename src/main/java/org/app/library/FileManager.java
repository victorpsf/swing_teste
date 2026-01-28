package org.app.library;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Objects;

import org.app.models.AppFile;

public class FileManager {
    private Path directory;

    private FileManager(Path directory) {
        this.directory = directory.normalize();
    }

    public static FileManager of(String directory) {
        return new FileManager(Paths.get(directory));
    }

    public String getPath() {
        return directory.toString();
    }

    public String concatPath(String... paths) {
        return directory.resolve(Paths.get("", paths)).toString();
    }

    public FileManager backDirectory() throws IOException {
        Path parent = directory.getParent();

        if (Objects.isNull(parent))
            throw new IOException(
                String.format(
                    "Don't have back directory for %s", 
                    this.directory.toString()
                )
            );

        return new FileManager(parent.normalize());
    }

    public FileManager nextDirectory(String path) {
        return new FileManager(
            directory.resolve(path).normalize()
        );
    }

    // 📖 Ler arquivo
    public AppFile read(String fileName) throws IOException {
        return AppFile.read(directory.resolve(fileName));
    }

    // ✍️ Criar / sobrescrever arquivo
    public AppFile write(AppFile file, byte[] content) throws IOException {
        return AppFile.write(file, content);
    }

    // ✍️ Criar / sobrescrever arquivo
    public AppFile write(String fileName, byte[] content) throws IOException {
        AppFile file = null;

        try {
            file = read(fileName);
        } catch (Exception e) {
            file = new AppFile(
                directory, 
                fileName, 
                (long) content.length, 
                content, 
                LocalDateTime.now()
            );
        }

        return write(file, content);
    }
}
