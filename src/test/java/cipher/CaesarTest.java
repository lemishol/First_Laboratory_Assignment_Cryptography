package cipher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaesarTest {

    @Test
    void toCipherPositiveKeyEnglish() {
        String expectedResult = "Ztte ndjg ugxtcsh radht, qji ndjg tctbxth radhtg.";
        String input = "Keep your friends close, but your enemies closer.";
        assertEquals(expectedResult, Caesar.toCipher(15, input));
    }

    @Test
    void toCipherNegativeKeyEnglish() {
        String expectedResult = "Vkrimhzktiar bl max iktvmbvx tgw lmnwr hy mxvagbjnxl yhk lxvnkx vhffngbvtmbhg bg max ikxlxgvx hy mabkw itkmbxl vteexw twoxkltkbxl.";
        String input = "Cryptography is the practice and study of techniques for secure communication in the presence of third parties called adversaries.";
        assertEquals(expectedResult, Caesar.toCipher(-7, input));
    }

    @Test
    void toCipherPositiveKeyUkrainian() {
        String expectedResult = "Жядою ґдгеєшю ґдшяаоу ешбфєдшївгсг йшзджроввн — йшзд ґщуеєовгряш.";
        String input = "Украй простий приклад симетричного шифрування — шифр підстановки.";
        assertEquals(expectedResult, Caesar.toCipher(18, input));
    }

    @Test
    void toCipherNegativeKeyUkrainian() {
        String expectedResult = "Їшозш клй ішнбішндтїе ібнйад ґшщбґкбтбїїч зйїпеабїсежїймне, сеиемїймне е шьнбїндтїймне еїпйлішсеє.";
        String input = "Наука про математичні методи забезпечення конфіденційності, цілісності і автентичності інформації.";
        assertEquals(expectedResult, Caesar.toCipher(-5, input));
    }

}