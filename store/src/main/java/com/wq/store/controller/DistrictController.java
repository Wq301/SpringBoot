package com.wq.store.controller;

import com.wq.store.pojo.District;
import com.wq.store.service.DistrictService;
import com.wq.store.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-18 14:34
 */
@RequestMapping("/districts")
@RestController
public class DistrictController extends BaseController{

    @Autowired
    DistrictService districtService;

    @RequestMapping({"/", ""})
    public JsonResult<List<District>> getByParent(String parent){
        List<District> data = districtService.findByParent(parent);
        return new JsonResult<>(OK,data);
    }
}