package com.amos.controller;

import com.alibaba.fastjson.JSONObject;
import com.amos.bean.*;
import com.amos.inputDto.CellMessage;
import com.amos.inputDto.UnitMessage;
import com.amos.returnJson.ReturnObject;
import com.amos.service.EstateService;
import javafx.scene.control.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstateController {
    @Autowired
    EstateService estateService;

    @RequestMapping("/estate/selectCompany")
    public String selectCompany() {
        List<TblCompany> companys = estateService.selectCompany();
        return JSONObject.toJSONString(new ReturnObject(companys));
    }

    @RequestMapping("/estate/insertEstate")
    public String insertEstate(FcEstate fcEstate){
        Integer rst = estateService.insertEstate(fcEstate);
        if(rst == 0)
            return JSONObject.toJSONString(new ReturnObject("房产编码已经存在","0"));
        return JSONObject.toJSONString(new ReturnObject("插入房产成功","1"));
    }

    @RequestMapping("/estate/selectBuilding")
    public String selectBuilding(Integer buildingNumber,String estateCode){
        List<FcBuilding> fcBuildingList = estateService.selectBuilding(buildingNumber, estateCode);
        return JSONObject.toJSONString(new ReturnObject(fcBuildingList));
    }

    @RequestMapping("/estate/updateBuilding")
    public String updateBuilding(FcBuilding fcBuilding){
        Integer result = estateService.updateBuilding(fcBuilding);
        if(result == 1)
            return JSONObject.toJSONString(new ReturnObject("更新成功","1"));
        return JSONObject.toJSONString(new ReturnObject("更新失败","0"));
    }

    @RequestMapping("/estate/selectUnit")
    public String selectUnit(@RequestBody UnitMessage[] unitMessages){
        List<FcUnit> fcUnitList = estateService.selectUnit(unitMessages);
        return JSONObject.toJSONString(new ReturnObject(fcUnitList));
    }

    @RequestMapping("/estate/updateUnit")
    public String updateUnit(FcUnit fcUnit){
        Integer result = estateService.updateUnit(fcUnit);
        if(result == 1)
            return JSONObject.toJSONString(new ReturnObject("更新成功","1"));
        return JSONObject.toJSONString(new ReturnObject("更新失败","0"));
    }

    @RequestMapping("/estate/insertCell")
    public String insertCell(@RequestBody CellMessage[] cellMessages){
        List<FcCell> fcCells = estateService.insertCell(cellMessages);
        return JSONObject.toJSONString(new ReturnObject(fcCells));
    }

    @RequestMapping("/estate/selectBuildingsByEstateCode")
    public String selectBuildingsByEstateCode(String estateCode){
        List<FcBuilding> fcBuildingList = estateService.selectBuildingsByEstateCode(estateCode);
        return JSONObject.toJSONString(new ReturnObject(fcBuildingList));
    }

    @RequestMapping("/estate/selectUnitByBuildingCode")
    public String selectUnitByBuildingCode(String buildingCode){
        List<FcUnit> fcUnitList = estateService.selectUnitByBuildingCode(buildingCode);
        return JSONObject.toJSONString(new ReturnObject(fcUnitList));
    }

    @RequestMapping("/estate/selectCellByUnitCode")
    public String selectCellByUnitCode(String unitCode){
        List<FcCell> fcCellList = estateService.selectCellByUnitCode(unitCode);
        return JSONObject.toJSONString(new ReturnObject(fcCellList));
    }

    @RequestMapping("/estate/updateCell")
    public String updateCell(FcCell fcCell){
        Integer result = estateService.updateCell(fcCell);
        if(result == 1)
            return JSONObject.toJSONString(new ReturnObject("更新成功","1"));
        return JSONObject.toJSONString(new ReturnObject("更新失败","0"));
    }

    @RequestMapping("/estate/selectEstate")
    public String selectEstate(String company) {
        List<FcEstate> estates = estateService.selectEstate(company);
        return JSONObject.toJSONString(new ReturnObject(estates));
    }
}
