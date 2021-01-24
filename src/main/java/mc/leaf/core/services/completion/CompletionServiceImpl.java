package mc.leaf.core.services.completion;

import mc.leaf.core.services.completion.enums.FilterMode;
import mc.leaf.core.services.completion.exceptions.CompletionException;
import mc.leaf.core.services.completion.interfaces.ICompletionService;
import mc.leaf.core.services.completion.interfaces.IMatchingResult;
import mc.leaf.core.services.completion.interfaces.ISyntax;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * This class implements the {@link ICompletionService} interface, providing an advanced completion system with support
 * for dynamic argument.
 *
 * @param <T>
 *         Type for a completion identifier. A completion identifier can be any object, but make sure that you can
 *         identify them between each other, or the whole purpose of this would be defeated.
 */
public class CompletionServiceImpl<T> implements ICompletionService<T> {


    private final Map<T, SyntaxContainer>     identifiersSyntax;


    public CompletionServiceImpl(Map<T, SyntaxContainer> identifiersSyntax) {

        this.identifiersSyntax = identifiersSyntax;
    }

    /**
     * Generate a {@link List} of {@link String} based on the provided user's input for handling completion.
     *
     * @param userInput
     *         The actual user's input-- to complete.
     *
     * @return A {@link List} of {@link String}
     */
    private static List<String> prepareUserInput(@NotNull String userInput) {
        List<String> input;
        if (userInput.endsWith(" ")) {
            // The string ends with a space, this one need to be enforced for the completion to work in any use-case.
            input = new ArrayList<>(Arrays.asList(userInput.trim().split(" ")));
            input.add("");
        } else {
            input = new ArrayList<>(Arrays.asList(userInput.trim().split(" ")));
        }
        return input;
    }


    @Override
    public @NotNull List<String> complete(@NotNull String input) {

        List<String> data = CompletionServiceImpl.prepareUserInput(input);

        return new ArrayList<>(new HashSet<>(this.identifiersSyntax.keySet().stream()
                .map(this.identifiersSyntax::get)
                .filter(container -> container.isCompletable(data))
                .map(SyntaxContainer::getCompletion)
                .flatMap(List::stream)
                .collect(Collectors.toList())));
    }

    private IMatchingResult<T> create(T identifier, SyntaxContainer container) {
        return new IMatchingResult<>() {

            /**
             * Get the completion identifier {@link T} resulting of this {@link
             * IMatchingResult}.
             *
             * @return A completion identifier {@link T}
             */
            @NotNull
            @Override
            public T getIdentifier() {

                return identifier;
            }

            /**
             * Retrieve the value of the provided dynamic completion argument.
             *
             * @param name
             *         Name of the dynamic completion argument.
             *
             * @return A {@link String}
             */
            @Override
            public String getParameter(String name) {

                return container.getMatches().get(name);
            }
        };
    }

    /**
     * Retrieve an {@link Optional} instance of {@link IMatchingResult}. The {@link Optional} won't be empty if one, and
     * only one completion identifier matches the user's input.
     *
     * @param userInput
     *         The user's input to match.
     *
     * @return An {@link Optional} {@link IMatchingResult}
     */
    @Override
    public Optional<IMatchingResult<T>> getMatchingIdentifier(@NotNull String userInput) {

        List<String> data = CompletionServiceImpl.prepareUserInput(userInput);

        List<T> identifiers = this.identifiersSyntax.keySet()
                .stream().filter(key -> this.identifiersSyntax.get(key).isMatching(data)).collect(Collectors.toList());

        if (identifiers.isEmpty()) {
            return Optional.empty();
        }

        if (identifiers.size() == 1) {
            T identifier = identifiers.get(0);
            SyntaxContainer container = this.identifiersSyntax.get(identifier);
            return Optional.of(this.create(identifier, container));
        }

        identifiers.sort(Comparator.comparing(this.identifiersSyntax::get));

        T idA = identifiers.get(0);
        T idB = identifiers.get(1);

        SyntaxContainer cA = this.identifiersSyntax.get(idA);
        SyntaxContainer cB = this.identifiersSyntax.get(idB);

        if (cA.getPriority() == cB.getPriority()) {
            return Optional.empty();
        } else {
            return Optional.of(this.create(idA, cA));
        }
    }

}
