package basicJava;


public class StringTest {
    public static void main(String[] args) throws Exception {
        testCharSet();
        testIntern();
    }

    private static void printnb(String s) {
        System.out.println(s);
    }

    private static void print(boolean f) {
        System.out.println(f);
    }

    private static void testIntern() {
        String str1 = "abc";
        String str2 = "abc";
        String str3 = "a";
        String str4 = "bc";
        String str5 = str3 + str4;
        String str6 = new String(str1);

        printnb("------no intern------");
        printnb("str1 == str2 ? ");
        print(str1 == str2);//true
        printnb("str1 == str5 ? ");
        print(str1 == str5);//false 字符串 + 先用一个StringBuilder append 然后toString()返回新对象，所以不是同一个引用。
        printnb("str1 == str6 ? ");
        print(str1 == str6);//false

        printnb("------intern------");
        printnb("str1.intern() == str2.intern() ? ");
        print(str1.intern() == str2.intern());//true
        printnb("str1.intern() == str5.intern() ? ");
        print(str1.intern() == str5.intern());//true
        printnb("str1.intern() == str6.intern() ? ");
        print(str1.intern() == str6.intern());//true
        printnb("str1 == str6.intern() ? ");
        print(str1 == str6.intern());//true
    }

    private static void testCharSet() throws Exception {
        // 默认utf-8，中文三字节，英文一字节；
        // gbk 中文两字节，英文一字节
        String charset = "gbk";
        // String charset = "utf-8";

        String s1 = "中文字符串", s2 = "hello";
        byte[] b1 = s1.getBytes(charset), b2 = s2.getBytes(charset);

        System.out.println(b1.length);
        System.out.println(b2.length);
    }
}

