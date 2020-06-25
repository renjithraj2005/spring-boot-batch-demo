package com.demo.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person,Person> {

    private Logger logger = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(Person person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getFirstName().toUpperCase();
        final Person transformedPerson = new Person(firstName,lastName);

        logger.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }
}
