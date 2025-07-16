package com.bms.management.system.controller;

import com.bms.management.system.dto.CreateShowRequestDto;
import com.bms.management.system.model.Show;
import com.bms.management.system.service.ShowServiceI;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
@AllArgsConstructor
public class ShowController {

    private final ShowServiceI showService;

     @PostMapping
     public Show createShow(@RequestBody CreateShowRequestDto createShowRequestDto) {
         return showService.createShow(createShowRequestDto);
     }

     @GetMapping("/{id}")
     public Show getShowById(@PathVariable Long id) {
         return showService.getShowById(id);
     }
}
