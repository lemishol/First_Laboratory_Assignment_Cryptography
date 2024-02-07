package main;


import cipher.Caesar;



public class Main {
    public static void main(String[] args) {
        System.out.println("Text to be encrypted with key=5 : ");
        String text = "Gentlemen, a short view back to the past. Thirty years ago, Niki Lauda told us ‘take a monkey, place him into the cockpit and he is able to drive the car.’ Thirty years later, Sebastian told us ‘I had to start my car like a computer, it’s very complicated.’ And Nico Rosberg said that during the race – I don’t remember what race - he pressed the wrong button on the wheel. Question for you both: is Formula One driving today too complicated with twenty and more buttons on the wheel, are you too much under effort, under pressure? What are your wishes for the future concerning the technical programme during the race? Less buttons, more? Or less and more communication with your engineers?";
        System.out.println(text);
        String encrypted = Caesar.toCipher(5, text);
        System.out.println(encrypted);
        System.out.println("Decrypted text:");
        System.out.println(Caesar.toDecipher(5,encrypted));
        String input = "Іцєгбдтьґдц, бдгцямач очс ьюмґциацж іцєгчо (дм стльцж ґеимґацж), хмофсц оцсмкдй стлье ґдмдцґдциае чаєбгямзчк вгб дтьґд вбочсбяютаал, їб ябфт недц оцьбгцґдмаб сюл хюмяе. Вчґюл очсьгцддл имґдбдабпб мамючхе о сто’лдбяе ґдбючддч, ямщфт оґч дмьч іцєгц ґдмюц нчюйі-ятаі ютпьб хюмяацяц сбґочситаця ємжчозтя. Ьюмґциач іцєгц хнтгтпюц вбвеюлгачґдй, о бґабоабяе, е оцпюлсч пбюбобюбябь. Ямщфт оґч іцєгц хмюцімюцґй нтххмжцґацяц втгтс ьгцвдбмамючхбя х оцьбгцґдмааля имґдбдабпб мамючхе сб оцамжбсе вбючмюємочдабпб іцєге. Оцамжчс вбюлпмо е дбяе, їбн оцьбгцґдбоеомдц гчхач іцєгц (амвгцьюмс, мюємочдц вчсґдмабоьц) сюл гчхацж имґдца вбочсбяютаал. Е вбючмюємочдабяе іцєгч Очфтатгм, мюпбгцдя іцєгеомаал оцьбгцґдбоеу ьюкибот ґюбоб, льт ьтгеу вчсґдмабоьбк ючдтг о хмютфабґдч очс дбпб, льм ючдтгм ьюкибобпб ґюбом оцьбгцґдбоеудйґл. Е ґтгтсцач дцґлим очґчяґбдцж гбьчо, Имгюйх Нтннчсф вбьмхмо, їб вбючмюємочдач іцєгц зйбпб дцве хмюціцюцґй имґдьбоб нтххмжцґацяц втгтс имґдбдаця мамючхбя.";
        System.out.println(input);
        System.out.println(Caesar.toDecipher(Caesar.getKey(input), input));


    }
}
