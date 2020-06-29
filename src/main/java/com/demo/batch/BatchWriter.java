package com.demo.batch;

import com.demo.batch.model.Person;
import com.demo.batch.repository.PersonRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class BatchWriter implements ItemWriter<Person> {

    @Autowired
    private PersonRepository personRepository;

    @Override
    @Transactional
    public void write(List<? extends Person> items) throws Exception {
        personRepository.saveAll(items);
    }
}
