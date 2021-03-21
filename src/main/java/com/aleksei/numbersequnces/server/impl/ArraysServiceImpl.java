package com.aleksei.numbersequnces.server.impl;

import com.aleksei.numbersequnces.model.ArraysModel;
import com.aleksei.numbersequnces.server.ArraysService;
import com.aleksei.numbersequnces.config.AppConfig;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class ArraysServiceImpl implements ArraysService {

    private final RestTemplate restTemplate;
    private final AppConfig appConfig;

    @Override
    public void generate(ArraysModel size) {
        restTemplate.postForEntity(appConfig.getGeneratorUrl(),size.getSize(),
                ArraysModel.class);
    }

    @Override
    public ArraysModel getRandomSequences() {
        ResponseEntity<ArraysModel> responseEntity =
            restTemplate.exchange(appConfig.getGeneratorUrl(),
                    HttpMethod.GET, null, new ParameterizedTypeReference<ArraysModel>() {
                    });
                ArraysModel arraysModel = responseEntity.getBody();
        return arraysModel;
    }
}
