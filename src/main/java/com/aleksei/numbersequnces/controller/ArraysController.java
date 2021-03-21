package com.aleksei.numbersequnces.controller;

import com.aleksei.numbersequnces.model.ArraysModel;
import com.aleksei.numbersequnces.server.ArraysService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping({"/", "/array"})
@RequiredArgsConstructor
public class ArraysController {

    @NonNull
    private ArraysService arraysService;

    @GetMapping
    public String generate(Model model) {
        model.addAttribute("size", new ArraysModel());
        return "array";
    }

    @PostMapping()
    public String saveSize(ArraysModel arraysModel) {
        arraysService.generate(arraysModel);
        return "table";
    }

    @GetMapping("/sequence")
    public String getSequences(Model model) {
        List<List<Long>> sequences = arraysService.getRandomSequences().getLists();
            model.addAttribute("sequences", sequences);
            return "table";
    }
}
