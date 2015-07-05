package nz.ben;

/**
 * Created by bengilbert on 5/07/15.
 */
public class Diamond {

    private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String printDiamond(Character lastCharacter) {
        int lastIndex = alphabet.lastIndexOf(lastCharacter);

        if (lastCharacter == 'A') {
            return "A";
        }

        String diamond =
                beforeCharacterPadding('A', lastCharacter) + "A\n";

        for (int i = 1; i <= lastIndex; i++) {
            Character currentCharacter = alphabet.charAt(i);
            diamond = diamond + diamondBodyLine(currentCharacter, lastCharacter);
        }

        for (int i = lastIndex - 1; i > 0; i--) {
            Character currentCharacter = alphabet.charAt(i);
            diamond = diamond + diamondBodyLine(currentCharacter, lastCharacter);
        }

        diamond = diamond +
                beforeCharacterPadding('A', lastCharacter) + "A\n";

        return diamond;
    }

    private String beforeCharacterPadding(Character currentCharacter, Character lastCharacter) {
        int paddingForCurrentCharacter = alphabet.lastIndexOf(lastCharacter) - alphabet.lastIndexOf(currentCharacter);

        return padding(paddingForCurrentCharacter);
    }

    private String betweenCharacterPadding(Character currentCharacter) {
        int currentCharacterIndex = alphabet.lastIndexOf(currentCharacter);
        int paddingBetweenCharacters = currentCharacterIndex * 2 - 1;

        return padding(paddingBetweenCharacters);
    }

    private String diamondBodyLine(Character currentCharacter, Character lastCharacter) {
        String diamondLine =
                beforeCharacterPadding(currentCharacter, lastCharacter) +
                        currentCharacter +
                        betweenCharacterPadding(currentCharacter) +
                        currentCharacter + "\n";
        return diamondLine;
    }

    private String padding(int length) {
        String padding = "";
        for (int i = 0; i < length; i++) {
            padding = padding + " ";
        }
        return padding;
    }


}
