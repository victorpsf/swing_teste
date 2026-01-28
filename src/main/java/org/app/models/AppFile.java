package org.app.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class AppFile {
    private final Path directory;
    private final String fileName;
    private final Long size;
    private final byte[] content;
    private final LocalDateTime lastUpdate;

    public AppFile(
        final Path directory,
        final String fileName,
        final Long size,
        final byte[] content,
        final LocalDateTime lastUpdate
    ) {
        this.directory = directory;
        this.fileName = fileName;
        this.size = size;
        this.content = content;
        this.lastUpdate = lastUpdate;
    }

    public Path getDirectory() { return this.directory; }
    public String getFileName() { return this.fileName; }
    public Long getSize() { return this.size; }
    public byte[] getContent() { return this.content; }
    public LocalDateTime getLastUpdate() { return this.lastUpdate; }

    public Path getFullPath() {
        return directory.resolve(fileName);
    }

    public static AppFile read(Path filePath) throws IOException {
        final byte[] content = Files.readAllBytes(filePath);

        return new AppFile(
            filePath.getParent(),
            filePath.getFileName().toString(),
            Files.size(filePath),
            content,
            LocalDateTime.ofInstant(
                Files.getLastModifiedTime(filePath).toInstant(),
                ZoneId.systemDefault()
            )
        );
    }

    public static AppFile write(AppFile file, byte[] content) throws IOException {
        final Path filePath = file.directory.resolve(file.fileName);

        Files.createDirectories(file.directory);
        Files.write(file.directory.resolve(file.fileName), content);

        return new AppFile(
            file.directory,
            file.fileName,
            (long) content.length,
            content,
            LocalDateTime.ofInstant(
                Files.getLastModifiedTime(filePath).toInstant(),
                ZoneId.systemDefault()
            )
        );
    }
}
