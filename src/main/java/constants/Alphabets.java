package constants;

public enum Alphabets {
    UKRAINIAN("абвгґдеєжзиіїйклмнопрстуфхцчшщьюя"),
    ENGLISH("abcdefghijklmnopqrstuvwxyz");
    private String alphabet;
    Alphabets(String alphabet) {
        this.alphabet = alphabet;
    }

    public String getAlphabet() {
        return alphabet;
    }
}
