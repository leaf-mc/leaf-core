package mc.leaf.core.services.completion;

import mc.leaf.core.services.completion.interfaces.IMatchingResult;
import mc.leaf.core.services.completion.interfaces.ISyntax;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Completion Service")
public class CompletionServiceTest {

    private static SyntaxContainer create(String... items) {

        return group(Arrays.stream(items).map(item -> ISyntax.getSyntax(item, dynamicOptions())).collect(Collectors.toList()));
    }

    private static SyntaxContainer group(List<ISyntax> syntaxList) {
        return new SyntaxContainer(syntaxList);
    }

    private static HashMap<Integer, SyntaxContainer> simpleInput() {

        HashMap<Integer, SyntaxContainer> input = new HashMap<>();
        input.put(1, create("language", "switch", "java"));
        input.put(2, create("language", "switch", "php"));
        input.put(3, create("language", "switch", "python"));
        input.put(4, create("language", "switch", "javascript"));
        input.put(5, create("language", "switch", "kotlin"));
        input.put(6, create("language", "switch", "c#"));
        input.put(7, create("language", "show", "message"));
        return input;
    }

    private static HashMap<Integer, SyntaxContainer> dynamicInput() {
        HashMap<Integer, SyntaxContainer> input = new HashMap<>();
        input.put(1, create("language", "switch", "{lang}"));
        input.put(2, create("language", "show", "message"));
        return input;
    }

    private static HashMap<String, List<String>> dynamicOptions() {
        HashMap<String, List<String>> options = new HashMap<>();
        options.put("lang", Arrays.asList("java", "php", "python", "javascript", "kotlin", "c#"));
        return options;
    }

    private static HashMap<Integer, SyntaxContainer> passThroughInput() {
        HashMap<Integer, SyntaxContainer> input = new HashMap<>();
        input.put(1, create("language", "switch", "[lang]"));
        input.put(2, create("language", "show", "message"));
        return input;
    }

    private static void assertListEquals(List<String> expected, List<String> actual) {
        expected.sort(String::compareTo);
        actual.sort(String::compareTo);
        assertArrayEquals(expected.toArray(new String[0]), actual.toArray(new String[0]));
    }

    @Test
    @DisplayName("Dynamic complete that should be empty")
    public void testDynamicCompleteShouldBeEmpty() {
        CompletionServiceImpl<Integer> service = new CompletionServiceImpl<>(dynamicInput());
        List<String>                   results = service.complete("language swit ja");
        assertListEquals(Collections.emptyList(), results);
    }

    @Test
    @DisplayName("Dynamic complete with a trailing space")
    public void testDynamicCompleteWithTrailingSpace() {
        CompletionServiceImpl<Integer> service = new CompletionServiceImpl<>(dynamicInput());
        List<String>                   results = service.complete("language switch ");
        assertListEquals(Arrays.asList("java", "php", "python", "javascript", "kotlin", "c#"), results);
    }

    @Test
    @DisplayName("Dynamic complete without trailing space")
    public void testDynamicCompleteWithoutTrailingSpace() {
        CompletionServiceImpl<Integer> service = new CompletionServiceImpl<>(dynamicInput());
        List<String>                   results = service.complete("language switch");
        assertListEquals(Collections.singletonList("switch"), results);
    }

    @Test
    @DisplayName("Dynamic completion on unfinished input")
    public void testDynamicCompletionOnUnfinishedInput() {
        CompletionServiceImpl<Integer> service = new CompletionServiceImpl<>(dynamicInput());
        List<String>                   results = service.complete("language switch j");
        assertListEquals(Arrays.asList("java", "javascript"), results);
    }

    @Test
    @DisplayName("Dynamic match that should be present")
    public void testDynamicMatchShouldBePresent() {
        CompletionServiceImpl<Integer>     service = new CompletionServiceImpl<>(dynamicInput());
        Optional<IMatchingResult<Integer>> results = service.getMatchingIdentifier("language switch java");
        assertTrue(results.isPresent());
    }

    @Test
    @DisplayName("Dynamic match that should have its parameter")
    public void testDynamicMatchShouldHaveParameter() {
        CompletionServiceImpl<Integer>     service = new CompletionServiceImpl<>(dynamicInput());
        Optional<IMatchingResult<Integer>> results = service.getMatchingIdentifier("language switch java");
        assertTrue(results.isPresent());
        assertEquals(results.get().getParameter("lang"), "java");
    }

    @Test
    @DisplayName("Dynamic match that should not be present (incomplete)")
    public void testDynamicMatchShouldNotBePresentWhenIncomplete() {
        CompletionServiceImpl<Integer>     service = new CompletionServiceImpl<>(dynamicInput());
        Optional<IMatchingResult<Integer>> results = service.getMatchingIdentifier("language swit java");
        assertFalse(results.isPresent());
    }

    @Test
    @DisplayName("Dynanmic match that should not be present (invalid)")
    public void testDynamicMatchShouldNotBePresentWhenInvalid() {
        CompletionServiceImpl<Integer>     service = new CompletionServiceImpl<>(dynamicInput());
        Optional<IMatchingResult<Integer>> results = service.getMatchingIdentifier("language swit java");
        assertFalse(results.isPresent());
    }

    @Test
    @DisplayName("Pass-through complete that should be empty")
    public void testPassThroughCompleteShouldBeEmpty() {
        CompletionServiceImpl<Integer> service = new CompletionServiceImpl<>(passThroughInput());
        List<String>                   results = service.complete("language swit ja");
        assertListEquals(Collections.emptyList(), results);
    }

    @Test
    @DisplayName("Pass-through complete with a trailing space")
    public void testPassThroughCompleteWithTrailingSpace() {
        CompletionServiceImpl<Integer> service = new CompletionServiceImpl<>(passThroughInput());
        List<String>                   results = service.complete("language switch ");
        assertListEquals(Collections.emptyList(), results);
    }

    @Test
    @DisplayName("Pass-through complete without trailing space")
    public void testPassThroughCompleteWithoutTrailingSpace() {
        CompletionServiceImpl<Integer> service = new CompletionServiceImpl<>(passThroughInput());
        List<String>                   results = service.complete("language switch");
        assertListEquals(Collections.singletonList("switch"), results);
    }

    @Test
    @DisplayName("Pass-through completion on unfinished input")
    public void testPassThroughCompletionOnUnfinishedInput() {
        CompletionServiceImpl<Integer> service = new CompletionServiceImpl<>(passThroughInput());
        List<String>                   results = service.complete("language switch j");
        assertListEquals(Collections.emptyList(), results);
    }

    @Test
    @DisplayName("Pass-through match that should be present")
    public void testPassThroughMatchShouldBePresent() {
        CompletionServiceImpl<Integer> service = new CompletionServiceImpl<>(passThroughInput());
        Optional<IMatchingResult<Integer>> results = service.getMatchingIdentifier("language switch java");
        assertTrue(results.isPresent());
    }

    @Test
    @DisplayName("Pass-through match that should have its parameter")
    public void testPassThroughMatchShouldHaveParameter() {
        CompletionServiceImpl<Integer> service = new CompletionServiceImpl<>(passThroughInput());
        Optional<IMatchingResult<Integer>> results = service.getMatchingIdentifier("language switch yes");
        assertTrue(results.isPresent());
        assertEquals(results.get().getParameter("lang"), "yes");
    }

    @Test
    @DisplayName("Pass-through match that should not be present (incomplete)")
    public void testPassThroughMatchShouldNotBePresentWhenIncomplete() {
        CompletionServiceImpl<Integer> service = new CompletionServiceImpl<>(passThroughInput());
        Optional<IMatchingResult<Integer>> results = service.getMatchingIdentifier("language swit java");
        assertFalse(results.isPresent());
    }

    // ==

    @Test
    @DisplayName("Pass-through match that should not be present (invalid)")
    public void testPassThroughMatchShouldNotBePresentWhenInvalid() {
        CompletionServiceImpl<Integer> service = new CompletionServiceImpl<>(passThroughInput());
        Optional<IMatchingResult<Integer>> results = service.getMatchingIdentifier("language swit java");
        assertFalse(results.isPresent());
    }

    @Test
    @DisplayName("Simple complete on unfinished input")
    public void testSimpleCompleteOnUnfinishedInput() {
        CompletionServiceImpl<Integer> service = new CompletionServiceImpl<>(simpleInput());
        List<String>                   results = service.complete("language switch j");
        assertListEquals(Arrays.asList("java", "javascript"), results);
    }

    @Test
    @DisplayName("Simple complete that should be empty")
    public void testSimpleCompleteShouldBeEmpty() {
        CompletionServiceImpl<Integer> service = new CompletionServiceImpl<>(simpleInput());
        List<String>                   results = service.complete("language swit ja");
        assertListEquals(Collections.emptyList(), results);
    }

    @Test
    @DisplayName("Simple complete with a trailing space")
    public void testSimpleCompleteWithTrailingSpace() {
        CompletionServiceImpl<Integer> service = new CompletionServiceImpl<>(simpleInput());
        List<String>                   results = service.complete("language switch ");
        assertListEquals(Arrays.asList("java", "php", "python", "javascript", "kotlin", "c#"), results);
    }

    @Test
    @DisplayName("Simple complete without trailing space")
    public void testSimpleCompleteWithoutTrailingSpace() {
        CompletionServiceImpl<Integer> service = new CompletionServiceImpl<>(simpleInput());
        List<String>                   results = service.complete("language switch");
        assertListEquals(Collections.singletonList("switch"), results);
    }

    @Test
    @DisplayName("Simple match that should be present")
    public void testSimpleMatchShouldBePresent() {
        CompletionServiceImpl<Integer>     service = new CompletionServiceImpl<>(simpleInput());
        Optional<IMatchingResult<Integer>> results = service.getMatchingIdentifier("language switch java");
        assertTrue(results.isPresent());
    }

    @Test
    @DisplayName("Simple match that should not be present (incomplete)")
    public void testSimpleMatchShouldNotBePresentWhenIncomplete() {
        CompletionServiceImpl<Integer>     service = new CompletionServiceImpl<>(simpleInput());
        Optional<IMatchingResult<Integer>> results = service.getMatchingIdentifier("language swit java");
        assertFalse(results.isPresent());
    }

    @Test
    @DisplayName("Simple match that should not be present (invalid)")
    public void testSimpleMatchShouldNotBePresentWhenInvalid() {
        CompletionServiceImpl<Integer>     service = new CompletionServiceImpl<>(simpleInput());
        Optional<IMatchingResult<Integer>> results = service.getMatchingIdentifier("language swit java");
        assertFalse(results.isPresent());
    }

}
