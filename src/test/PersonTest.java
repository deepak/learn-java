package test;

import main.Person;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testEquals() throws Exception {
        Person person = new Person("p1", 40, 123456);
        Person samePerson = new Person("p1", 40, 123456);
        Person differentPerson = new Person("p2", 40, 123456);

        assertThat(person, is(equalTo(samePerson)));
        assertThat(person, is(not(equalTo(differentPerson))));
    }
}