import java.util.*;
import java.util.stream.Collectors;

public class PuttingIntoPractice {
    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1
        System.out.println("------1------");
        transactions.stream()
                .filter(s->s.getYear()==2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);

        //2
        System.out.println("------2------");
        Set<String> set=transactions.stream()
                                    .map(s->s.getTrader().getCity())
                                    .collect(Collectors.toSet());
        System.out.println(set);

        //3
        System.out.println("------3------");
        transactions.stream()
                    .map(s->s.getTrader())
                .filter(s->s.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        //4
        System.out.println("------4------");
        String reduce=transactions.stream()
                .map(s->s.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (x1,x2)->x1+" "+x2);
        System.out.println(reduce);

        //5
        System.out.println("------5------");
        boolean anyMatch=transactions.stream()
                .anyMatch(s->s.getTrader().getCity().equals("Milan"));
        System.out.println(anyMatch);

        //6
        System.out.println("------6------");
        transactions.stream()
                .filter(s->s.getTrader().getCity().equals("Cambridge"))
                .map(s->s.getValue())
                .forEach(System.out::println);

        //7
        System.out.println("------7------");
        Optional<Integer> reduceMax=transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(reduceMax);

        //8
        System.out.println("------8------");
        Optional<Integer> reduceMin=transactions.stream()
                                   .map(Transaction::getValue)
                                   .reduce(Integer::min);
        System.out.println(reduceMin);
    }
}
