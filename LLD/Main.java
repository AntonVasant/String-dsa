package LLD;



public class Main {
    public static void main(String a[]) {
        String s = "hey this is just a testing for the text implementation of a text editor which have few features similar text to the normal text editor hope it works fine";
        TextEditor textEditor = new TextEditor();
        textEditor.initialize(s);
        textEditor.printAll();
        textEditor.textJustify(18);
    }
}
