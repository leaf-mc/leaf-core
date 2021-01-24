package mc.leaf.core.services.completion.interfaces;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

/**
 * Interface representing a completion service.
 *
 * @param <T>
 *         Type for a completion identifier. A completion identifier can be any object, but make sure that you can
 *         identify them between each other, or the whole purpose of this would be defeated.
 *
 * @author alexpado
 */
public interface ICompletionService<T> {

    /**
     * Retrieve a {@link List} of {@link String} completing the user's input.
     *
     * @param userInput
     *         The user's input to complete.
     *
     * @return A {@link List} of {@link String}
     */
    @NotNull List<String> complete(@NotNull String userInput);

    /**
     * Retrieve an {@link Optional} instance of {@link IMatchingResult}. The {@link Optional} won't be empty if one, and
     * only one completion identifier matches the user's input.
     *
     * @param userInput
     *         The user's input to match.
     *
     * @return An {@link Optional} {@link IMatchingResult}
     */
    Optional<IMatchingResult<T>> getMatchingIdentifier(@NotNull String userInput);

}
