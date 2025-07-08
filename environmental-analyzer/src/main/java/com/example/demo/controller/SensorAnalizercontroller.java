package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SensorAnalizer;
import com.example.demo.service.SensorAnalizerService;

@RestController
@RequestMapping("/sensor-analizer")
public class SensorAnalizercontroller {
	@Autowired
    private SensorAnalizerService analizerService;

    @GetMapping
    public ResponseEntity<List<SensorAnalizer>> obtenerTodos() {
        return ResponseEntity.ok(analizerService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        return analizerService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
