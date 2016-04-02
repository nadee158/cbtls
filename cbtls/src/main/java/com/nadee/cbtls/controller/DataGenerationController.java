package com.nadee.cbtls.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nadee.cbtls.service.DataGenerationService;

@Controller
@RequestMapping(value = "/admin")
public class DataGenerationController {

  @Autowired
  private DataGenerationService dataGenerationService;

  @RequestMapping(value = "/generateData", method = RequestMethod.GET)
  public @ResponseBody Map<String, Object> generateData() {
    Map<String, Object> map = new HashMap<String, Object>();
    try {
      return dataGenerationService.generateData();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return map;
  }



}
