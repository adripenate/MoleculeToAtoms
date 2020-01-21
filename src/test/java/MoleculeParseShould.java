import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class MoleculeParseShould {
    @Test
    public void throw_an_exception_when_is_not_a_molecule() {
        assertThatIllegalArgumentException().isThrownBy(() -> MoleculeParse.parse("pie"));
    }

    private static class MoleculeParse {
        public static Map<String, Integer> parse(String molecule) throws IllegalArgumentException {
            throw new IllegalArgumentException();
        }
    }
}
