package Lab1;

public class TestCase{
    public static void main(String[] args) {
        SymbolTable s = new SymbolTable(7);
        System.out.println(s.hash("het"));
        s.put("het", 'c');
        s.put("the", 'd');
        s.dump();
        System.out.println(s.get("the"));
        s.put("the", 'i');
        s.dump();
        System.out.println(s.hash("info"));
        s.put("info", 'd');
        System.out.println(s.hash("fusk"));
        s.put("fusk", 'c');
        s.dump();
        s.delete("het");
        s.dump();
        System.out.println();
        System.out.println(s.get("het"));
        System.out.println(s.size());
    }

}
