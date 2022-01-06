package mc.leaf.core.services.completion.interfaces;

import mc.leaf.core.services.completion.impl.MatchSyntax;
import mc.leaf.core.services.completion.impl.PassThroughSyntax;
import mc.leaf.core.services.completion.impl.SelectiveSyntax;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface ISyntax {

    static ISyntax getSyntax(String syntax, Map<String, List<String>> options) {

        if (syntax.startsWith("[") && syntax.endsWith("]")) {
            return new PassThroughSyntax(syntax);
        } else if (syntax.startsWith("{") && syntax.endsWith("}")) {
            String name = syntax.substring(1, syntax.length() - 1);
            return new SelectiveSyntax(syntax, options.getOrDefault(name, Collections.emptyList()));
        } else {
            return new MatchSyntax(syntax);
        }

    }

    @NotNull
    String getName();

    boolean isMatching(@NotNull String data);

    boolean isCompletable(@NotNull String data);

    @NotNull
    List<String> complete(@NotNull String data);

}
