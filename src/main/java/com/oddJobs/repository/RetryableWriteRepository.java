package com.oddJobs.repository;

import com.mongodb.MongoException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RetryableWriteRepository<T> {

    private final MongoTemplate mongoTemplate;

    @Retryable(exceptionExpression = "message.contains('" + MongoException.TRANSIENT_TRANSACTION_ERROR_LABEL + "')")
    public <S extends T> S save(S objToSave) {return mongoTemplate.save(objToSave);}

    @Retryable(exceptionExpression = "message.contains('" + MongoException.TRANSIENT_TRANSACTION_ERROR_LABEL + "')")
    public <S extends T> S insert(S objToSave) {return mongoTemplate.insert(objToSave);}

}
