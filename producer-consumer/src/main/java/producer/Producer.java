package producer;

import domain.Person;
import domain.Validation;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Producer extends Thread {

    private BlockingQueue<Person> queue;

    public Producer(BlockingQueue<Person> queue) {
        this.queue = queue;
    }

    @Override
    public void run(){
        try(Scanner scanner = new Scanner(new File("./producer-consumer/src/main/resources/input.txt")).useDelimiter("%")) {

            int total = 0;

            while (scanner.hasNext()) {
                total += 1;
                String nextPerson = scanner.next();

                if (Validation.isValid(nextPerson)) {
                    String[] tokens = nextPerson.split("~");

                    String name1 = tokens[0];
                    String name2 = tokens[1];
                    String name3 = tokens[2];

                    Long CNP = Long.parseLong(tokens[3]);

                    String email = tokens[4];

                    Person person = new Person(name1, name2, name3, CNP, email);

                    queue.put(person);
                }
            }

            queue.put(new Person("","","",0l,""));

            System.out.println("Total in Producer: " + total);

        }  catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}