class Variables {
    public static void main(String[] args) {
        System.out.println("Hello Guys");
        System.out.print(510);
        System.out.println(" and the count continues");

        int age;
        age = 25;
        System.out.println(age);

        age = 26;
        System.out.println(age);

        short shotnum = 10000;
        System.out.println(shotnum);

        long longnum = 100000000000l;
        System.out.println(longnum);

        double dbl = 1.25;
        System.out.println(dbl);

        float flt = 1.26f;
        System.out.println(flt);

        boolean a = true;
        boolean b = false;
        System.out.println(a);
        System.out.println(b);

        char chr = '$';
        System.out.println(chr);

        long lg = 15;
        int nt = 30;
        lg = nt; // int (30) is automatically converted to long
        System.out.println(lg);
    }
}