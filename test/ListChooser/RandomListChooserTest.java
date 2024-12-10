package ListChooser;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RandomListChooserTest {
    
    @Test
    void testChooseWithEmptyList() {
        RandomListChooser<Integer> chooser = new RandomListChooser<>();
        List<Integer> emptyList = new ArrayList<>();
        assertNull(chooser.choose("Choose an item", emptyList));
    }

    @Test
    void testChooseWithNonEmptyList() {
        RandomListChooser<String> chooser = new RandomListChooser<>();
        List<String> list = Arrays.asList("Apple", "Banana", "Orange");
        String chosen = chooser.choose("Choose a fruit", list);
        assertTrue(list.contains(chosen));
    }
}
