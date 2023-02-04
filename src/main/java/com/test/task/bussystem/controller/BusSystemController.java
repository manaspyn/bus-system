package com.test.task.bussystem.controller;

import com.test.task.bussystem.Service.BusSystemService;
import com.test.task.bussystem.model.BusDirection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BusSystemController {
    private final BusSystemService busSystemService;

    public BusSystemController(BusSystemService busSystemService) {
        this.busSystemService = busSystemService;
    }

    @GetMapping("/direct")
    public ResponseEntity<BusDirection> direct(@RequestParam String from, @RequestParam String to){
        BusDirection result = this.busSystemService.checkDirection(from, to);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
