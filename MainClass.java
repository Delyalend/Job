import java.util.ArrayList;



public class MainClass {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        Phone phone1 = new Phone();
        phone1.setModel("IPhone");
        ArrayList<String> favoriteBooks = new ArrayList<>();
        favoriteBooks.add("Kniga1");
        favoriteBooks.add("Kniga2");

        Man man1 = new Man("Petr", 18, favoriteBooks, phone1);

        Man man2 = (Man)DeepCopy.CopyObject(man1);

        System.out.println("name1: " + man1.getName() + " Age1:" + man1.getAge() + " FB1:" + man1.getFavoriteBooks() + "P1:" + man1.getPhone().getModel());
        System.out.println("name2: " + man2.getName() + " Age2:" + man2.getAge() + " FB2:" + man2.getFavoriteBooks() + "P2:" + man2.getPhone().getModel());


        man1.setName("Leha");
        man1.getFavoriteBooks().clear();
        man1.getFavoriteBooks().add("Bestseller");
        man1.getFavoriteBooks().add("BadSeller");
        man1.getPhone().setModel("Motorolla");

        System.out.println("name1: " + man1.getName() + " Age1:" + man1.getAge() + " FB1:" + man1.getFavoriteBooks() + "P1:" + man1.getPhone().getModel());
        System.out.println("name2: " + man2.getName() + " Age2:" + man2.getAge() + " FB2:" + man2.getFavoriteBooks() + "P2:" + man2.getPhone().getModel());


    }
}
