package com.aleksei.numbersequnces.server;

import com.aleksei.numbersequnces.model.ArraysModel;

public interface ArraysService {

    void generate(ArraysModel model);
    ArraysModel getRandomSequences();
}
