package jd2.phoneBook;

public class PhoneBookReader {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add("John","Lock", "jlock@mail.com", 487369286);
        pb.add("Joe","Doe", "jdoe@mail.com", 1846359927);
        pb.add("Adam","Petty", "apetty@mail.com", 1957639072);
//        pb.print();
        System.out.println(pb.findByName("Adam"));


    }

}
