package mc.leaf.core.services.completion.impl;

import mc.leaf.core.services.completion.interfaces.ISyntax;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class SelectiveSyntax implements ISyntax {

    private final String       name;
    private final List<String> values;

    public SelectiveSyntax(String name, List<String> values) {

        if (!name.startsWith("{") || !name.endsWith("}") || name.length() < 3) {
            throw new IllegalArgumentException("Invalid name.");
        }

        this.name   = name.substring(1, name.length() - 1);
        this.values = values.stream().map(String::toLowerCase).collect(Collectors.toList());
    }

    @Override
    public @NotNull String getName() {

        return this.name;
    }

    @Override
    public boolean isMatching(@NotNull String data) {

        return this.values.contains(data.toLowerCase());
    }

    @Override
    public boolean isCompletable(@NotNull String data) {

        return this.values.stream().anyMatch(value -> value.startsWith(data.toLowerCase()));
    }

    @Override
    public @NotNull List<String> complete(@NotNull String data) {

        return this.values.stream().filter(value -> value.startsWith(data.toLowerCase())).collect(Collectors.toList());
    }

}
