package mc.leaf.core.services.completion.impl;

import mc.leaf.core.services.completion.interfaces.ISyntax;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class MatchSyntax implements ISyntax {

    private final String name;

    public MatchSyntax(String name) {

        this.name = name;
    }

    @Override
    public @NotNull String getName() {

        return this.name;
    }

    @Override
    public boolean isMatching(@NotNull String data) {

        return this.name.equals(data);
    }

    @Override
    public boolean isCompletable(@NotNull String data) {

        return this.name.startsWith(data);
    }

    @Override
    public @NotNull List<String> complete(@NotNull String data) {

        return Collections.singletonList(this.name);
    }

}
