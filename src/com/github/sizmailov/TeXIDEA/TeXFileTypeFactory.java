package com.github.sizmailov.TeXIDEA;

import com.intellij.openapi.fileTypes.*;
import org.jetbrains.annotations.NotNull;

public class TeXFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(TeXFileType.INSTANCE);
    }
}
