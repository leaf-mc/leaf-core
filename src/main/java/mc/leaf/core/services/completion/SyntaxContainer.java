package mc.leaf.core.services.completion;

import mc.leaf.core.services.completion.impl.MatchSyntax;
import mc.leaf.core.services.completion.impl.PassThroughSyntax;
import mc.leaf.core.services.completion.impl.SelectiveSyntax;
import mc.leaf.core.services.completion.interfaces.ISyntax;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class SyntaxContainer implements Comparable<SyntaxContainer> {

    private final List<ISyntax> syntaxList;

    private final Map<String, String> matches;
    private final List<String>        completion;

    public SyntaxContainer(List<ISyntax> syntaxList) {

        this.syntaxList = syntaxList;
        this.matches    = new HashMap<>();
        this.completion = new ArrayList<>();
    }

    @Override
    public int compareTo(@NotNull SyntaxContainer o) {

        return Integer.compare(this.getPriority(), o.getPriority());
    }

    public List<String> getCompletion() {

        return this.completion;
    }

    public Map<String, String> getMatches() {

        return this.matches;
    }

    public int getPriority() {

        Class<? extends ISyntax> clazz = this.syntaxList.get(this.syntaxList.size() - 1).getClass();

        if (clazz == MatchSyntax.class) {
            return 0;
        } else if (clazz == PassThroughSyntax.class) {
            return 1;
        } else if (clazz == SelectiveSyntax.class) {
            return 2;
        }

        return Integer.MAX_VALUE;
    }

    public boolean isCompletable(List<String> input) {

        this.completion.clear();

        if (input.size() > this.syntaxList.size()) {
            return false;
        }

        for (int i = 0; i < input.size(); i++) {
            ISyntax syntax   = this.syntaxList.get(i);
            String  argument = input.get(i);
            boolean isLast   = i == input.size() - 1;

            if ((isLast && !syntax.isCompletable(argument)) || (!isLast && !syntax.isMatching(argument))) {
                return false;
            }

            if (isLast) {
                this.completion.addAll(syntax.complete(argument));
            }
        }

        return true;
    }

    public boolean isMatching(List<String> input) {

        this.matches.clear();

        if (input.size() != this.syntaxList.size()) {
            return false;
        }

        for (int i = 0; i < input.size(); i++) {
            ISyntax syntax   = this.syntaxList.get(i);
            String  argument = input.get(i);

            if (!syntax.isMatching(argument)) {
                return false;
            }

            this.matches.put(syntax.getName(), argument);
        }

        return true;
    }


}
