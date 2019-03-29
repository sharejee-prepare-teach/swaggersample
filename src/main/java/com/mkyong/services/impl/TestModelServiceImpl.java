package com.mkyong.services.impl;

import com.mkyong.models.TestModel;
import com.mkyong.repositories.TestModelRepository;
import com.mkyong.services.TestModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Create By: Ron Rith
 * Create Date on: 3/29/2019.
 */
@Service
@Transactional
public class TestModelServiceImpl implements TestModelService {
    @Autowired
    private TestModelRepository testModelRepository;

    @Override
    public List<TestModel> getAll() {
        List<TestModel> testModels = (List<TestModel>) testModelRepository.findAll();
        Boolean b = false;
        if (testModels.isEmpty()) {
            b = true;
            for (int i = 0; i < 10; i++) {
                TestModel testModel = new TestModel();
                testModel.setName("test model " + i);
                testModelRepository.save(testModel);
            }
        }
        if (b == true) {
            return (List<TestModel>) testModelRepository.findAll();
        } else {
            return testModels;
        }
    }
}
