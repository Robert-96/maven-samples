import consumer.Consumer;
import domain.Person;
import domain.Validation;
import producer.Producer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    private static void restoreObjects(){

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./producer-consumer/src/main/resources/output.txt", true));
             Scanner scanner = new Scanner(new File("./producer-consumer/src/main/resources/input.txt")).useDelimiter("%")) {

            int total = 0;
            int valid = 0;

            while(scanner.hasNext()) {
                total += 1;

                String nextPerson = scanner.next();

                if (Validation.isValid(nextPerson)) {
                    valid += 1;

                    String[] tokens = nextPerson.split("~");

                    String name1 = tokens[0];
                    String name2 = tokens[1];
                    String name3 = tokens[2];

                    Long CNP = Long.parseLong(tokens[3]);

                    String email = tokens[4];

                    Person person = new Person(name1, name2, name3, CNP, email);

                    bufferedWriter.write(person.toString());
                }
            }

            System.out.println("Total: " + total);
            System.out.println("Valid: " + valid);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void restoreObjectsWithProducerConsumer(){
        BlockingQueue<Person> queue = new LinkedBlockingQueue<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        restoreObjects();
        System.out.println();
        restoreObjectsWithProducerConsumer();
    }
}