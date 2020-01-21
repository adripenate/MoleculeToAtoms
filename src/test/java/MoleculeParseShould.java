import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class MoleculeParseShould {
    @Test
    public void throw_an_exception_when_is_not_a_molecule() {
        assertThatIllegalArgumentException().isThrownBy(() -> MoleculeParse.parse("pie"));
    }

    @Test
    public void parse_molecule_H() {
        Map<String, Integer> expectedResult = new HashMap<String, Integer>(){{
            put("H", 1);
        }};
        assertThat(MoleculeParse.parse("H")).isEqualTo(expectedResult);
    }

    @Test
    public void parse_molecule_H2() {
        Map<String, Integer> expectedResult = new HashMap<String, Integer>(){{
            put("H", 2);
        }};
        assertThat(MoleculeParse.parse("H2")).isEqualTo(expectedResult);
    }

    private static class MoleculeParse {
        public static Map<String, Integer> parse(String molecule) throws IllegalArgumentException {
            if (isInvalidMolecule(molecule)) throw new IllegalArgumentException();
            int molecules = (molecule.length() == 1)? 1 : Integer.parseInt(molecule.charAt(1) + "");
            return new HashMap<String, Integer>(){{
                put("H", molecules);
            }};
        }

        private static boolean isInvalidMolecule(String molecule) {
            return molecule.matches("^[a-z].*");
        }
    }
}
