package mc.leaf.core.services.completion.impl;

import mc.leaf.core.services.completion.interfaces.ISyntax;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class PassThroughSyntax implements ISyntax {

    private final String name;

    public PassThroughSyntax(String name) {

        if (!name.startsWith("[") || !name.endsWith("]") || name.length() < 3) {
            throw new IllegalArgumentException("Invalid name.");
        }

        this.name = name.substring(1, name.length() - 1);
    }

    @Override
    public @NotNull String getName() {

        return this.name;
    }

    @Override
    public boolean isMatching(@NotNull String data) {

        return true;
    }

    @Override
    public boolean isCompletable(@NotNull String data) {

        return true;
    }

    @Override
    public @NotNull List<String> complete(@NotNull String data) {

        return Collections.emptyList();
    }

}
