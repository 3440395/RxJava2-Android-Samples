import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by xuekai on 2017/5/11.
 */

public class sss {
    public static void main(String[] arg){
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(2);
        objects.add(3);
        objects.add(4);
        objects.add(5);
        objects.add(6);
        objects.add(11);
        objects.add(12);
        objects.add(14);
        objects.add(16);
        objects.add(24);
        objects.add(30);
        objects.add(37);
        objects.add(38);
        objects.add(49);
        objects.add(68);
        objects.add(71);
        objects.add(74);
        objects.add(76);
        objects.add(79);



        objects.add(37);
        objects.add(52);
        objects.add(7);
        objects.add(17);
        objects.add(28);
        objects.add(35);
        objects.add(36);
        objects.add(39);
        objects.add(41);
        objects.add(45);
        objects.add(57);
        objects.add(63);
        objects.add(73);
        objects.add(77);



        objects.add(23);
        objects.add(26);
        objects.add(29);
        objects.add(46);
        objects.add(51);
        objects.add(53);
        objects.add(65);
        objects.add(66);





        objects.add(1);
        objects.add(8);
        objects.add(9);
        objects.add(13);
        objects.add(15);
        objects.add(19);
        objects.add(20);
        objects.add(25);
        objects.add(27);
        objects.add(34);
        objects.add(44);
        objects.add(47);
        objects.add(48);
        objects.add(55);
        objects.add(58);
        objects.add(59);
        objects.add(60);
        objects.add(61);
        objects.add(62);
        objects.add(67);
        objects.add(72);
        objects.add(78);
        objects.add(82);

        objects.add(10);
        objects.add(18);
        objects.add(21);
        objects.add(22);
        objects.add(33);
        objects.add(40);
        objects.add(42);
        objects.add(43);
        objects.add(50);
        objects.add(64);
        objects.add(81);
        objects.add(83);
        objects.add(84);



        objects.add(31);
        objects.add(54);
        objects.add(56);
        objects.add(70);
        objects.add(75);
        objects.add(80);
//        32    37  69
        Object[] objects1 = objects.toArray();
        Arrays.sort(objects1);
        System.out.println(objects1.length);
        for (Object o : objects1) {
            System.out.println(o);
        }
    }
}




















