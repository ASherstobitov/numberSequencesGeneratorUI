package com.aleksei.numbersequnces.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArraysModel {

    private Integer size;

    private List<List<Long>> lists;
}

