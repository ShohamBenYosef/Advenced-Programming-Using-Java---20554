public class Main {

    public static void main(String[] args) throws IllegalArgumentException {

        Student st1 = new Student("Shir", "SA", 111, 1993);
        Student st2 = new Student("Ruth", "QW", 222, 1994);
        Student st3 = new Student("Or", "ER", 333, 1998);
        Student st4 = new Student("Ron", "VF", 444, 1991);
        Student st5 = new Student("Yair", "NH", 555, 1990);
        Student st6 = new Student("Tom", "JH", 666, 2000);

        Student st7 = new Student("new", "one", 777, 1880);

        String[] phoneNumValues = {"05236", "04515", "78541", "95821", "32569", "58340"};
        Student[] studentsKeys = {st1, st2, st3, st4, st5, st6};


        try {
            AssociationTable<Student, String> phoneBook = new AssociationTable<Student, String>(studentsKeys, phoneNumValues);

            System.out.println("get( st3): " + phoneBook.get(st3)); // should be 78541

            System.out.println("remove( st3): " + phoneBook.remove(st3)); // should be true
            System.out.println("print st3 - check remove: " + phoneBook.get(st3)); // should be null

            System.out.println(phoneBook.contains(st5));  // should be true

            phoneBook.add(st7, "8452000000");
            System.out.println(phoneBook.get(st7)); // should be 8452000000


        }catch (java.lang.IllegalArgumentException e){
            throw new IllegalArgumentException("Key/Value not the same size.");
        }


    }
}


