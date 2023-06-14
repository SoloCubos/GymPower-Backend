package com.gympower.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gympower.web.entities.Instructor;
import com.gympower.web.services.impl.InstructorServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/gympower/instructores")
public class InstructorController extends BaseControllerImpl<Instructor, InstructorServiceImpl>{

    @Autowired
    private InstructorServiceImpl instructorServiceImpl;
    
}
