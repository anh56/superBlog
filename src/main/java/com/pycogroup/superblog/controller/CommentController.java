package com.pycogroup.superblog.controller;

import com.pycogroup.superblog.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private ModelMapper modelMapper;


}

