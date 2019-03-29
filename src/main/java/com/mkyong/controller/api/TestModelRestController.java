package com.mkyong.controller.api;

import com.mkyong.models.TestModel;
import com.mkyong.models.responses.*;
import com.mkyong.models.responses.failure.ResponseListFailure;
import com.mkyong.services.testmodel.TestModelService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create By: Ron Rith
 * Create Date on: 3/29/2019.
 */
@RestController
@RequestMapping("/api")
public class TestModelRestController {
    @Autowired
    private TestModelService testModelService;

    private HttpStatus httpStatus = HttpStatus.OK;

    @GetMapping(value="" , headers = "Accept=application/json")
    @ApiOperation(value="View list of testModel")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Successfully retrieved list"),
            @ApiResponse(code=401,message="You are not authorized to view the resource")
    })
    private ResponseEntity<ResponseList<TestModel>> findAllTestModels() {
        ResponseList<TestModel> testModelResponseList = new ResponseList<>();
        try {
            List<TestModel> testModels = testModelService.getAll();
            if (!testModels.isEmpty()) {
                httpStatus = HttpStatus.OK;
                testModelResponseList = new ResponseList<TestModel>(
                        HttpMessage.success(Table.TESTMODEL, Transaction.Success.RETRIEVE),  // message
                        true,  // status
                        testModels,  // data
                        null); // pagination
            } else {
                httpStatus = HttpStatus.NOT_FOUND;
                testModelResponseList = new ResponseListFailure<TestModel>(
                        HttpMessage.fail(Table.TESTMODEL, Transaction.Fail.RETRIEVE), // message
                        false, // status
                        ResponseHttpStatus.RECORD_NOT_FOUND // error
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            testModelResponseList = new ResponseListFailure<TestModel>(
                    HttpMessage.fail(Table.TESTMODEL, Transaction.Fail.RETRIEVE),
                    false,
                    ResponseHttpStatus.INTERNAL_SERVER_ERROR
            );
        }
        return new ResponseEntity<ResponseList<TestModel>>(testModelResponseList, httpStatus);
    }
}
