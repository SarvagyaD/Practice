import java.util.*;
import java.util.stream.Collectors;

public class TestProgram {

    public TestProgram(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    String firstName ;
    String lastName;

    public static void main(String[] args) {


        TestProgram t1 = new TestProgram("Sarvagya", "Dixit");

        TestProgram t2 =new TestProgram("Akshay", "jain");
        TestProgram t3 =new TestProgram("Sarvagya", "Dixit");
        TestProgram t4 =new TestProgram("Akshay", "jain");
        TestProgram t5 =new TestProgram("Akshay", "jain");

        HashSet<TestProgram> set=new HashSet<>();
        set.add(t1);
        set.add(t2);
        set.add(t3);
        set.add(t4);
        set.add(t5);

/*
        System.out.println("set "+ set.forEach(TestProgram:: ););
*/
    for(TestProgram test : set) {
        System.out.println(test.toString());

        String input=" Java cocept of the day";

        Map<Character, Integer> CharCountMap =new LinkedHashMap<>();
        input.chars().forEach(c -> CharCountMap.merge((char)c, 1, Integer::sum));
        char nonRepetitive= CharCountMap.entrySet().stream().filter(entry -> entry.getValue()==1).map(Map.Entry ::getKey)
                .findFirst().orElse('\0');
        System.out.println("Non repetetive char " +nonRepetitive);
    }

//        List<Integer> arr =Arrays.asList(10,15,8,49,25,98,98,32,15);

//            int []arr={1,4,9,2,2,35,54,3,4,4,54,1,1};
//            int sum = 0;
//           Map<Integer,Integer> frequency = new HashMap<>();
//        for(int num :arr){
//            frequency.put(num, frequency.getOrDefault(num,0)+1);
//        }
//        for(int num :arr){
//            if(frequency.get(num)==1){
//                sum +=num;
//            }
//        }
//
//        System.out.println("sum : "+sum);






    }

}
