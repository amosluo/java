package com.amos.service;

import com.amos.bean.*;
import com.amos.inputDto.CellMessage;
import com.amos.inputDto.UnitMessage;
import com.amos.mapper.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import javafx.scene.control.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstateService {
    @Autowired
    TblCompanyMapper tblCompanyMapper;

    @Autowired
    FcEstateMapper fcEstateMapper;

    @Autowired
    FcBuildingMapper fcBuildingMapper;

    @Autowired
    FcUnitMapper fcUnitMapper;

    @Autowired
    FcCellMapper fcCellMapper;

    public List<TblCompany> selectCompany() {
        List<TblCompany> companys = tblCompanyMapper.selectCompanyName();
        return companys;
    }

    public Integer insertEstate(FcEstate fcEstate) {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("estate_code", fcEstate.getEstateCode());
        FcEstate findEstate = fcEstateMapper.selectOne(queryWrapper);
        if (findEstate != null)
            return 0;
        return fcEstateMapper.insert(fcEstate);
    }

    public List<FcBuilding> selectBuilding(Integer buildingNumber, String estateCode) {
        List<FcBuilding> fcBuildingList = new ArrayList<>();
        for (int i = 0; i++ < buildingNumber; ) {
            FcBuilding fcBuilding = new FcBuilding();
            fcBuilding.setBuildingCode(estateCode + "-B" + i);
            fcBuilding.setBuildingName("第" + i + "号楼");
            fcBuilding.setEstateCode(estateCode);
            fcBuildingMapper.insert(fcBuilding);
            fcBuildingList.add(fcBuilding);
        }
        return fcBuildingList;
    }

    public Integer updateBuilding(FcBuilding fcBuilding) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("id", fcBuilding.getId());
        return fcBuildingMapper.update(fcBuilding, updateWrapper);
    }

    public List<FcUnit> selectUnit(UnitMessage[] unitMessages) {
        List<FcUnit> fcUnitList = new ArrayList<>();
        for (UnitMessage unitMessage : unitMessages) {
            for (int i = 0; i++ < unitMessage.getUnitCount(); ) {
                FcUnit fcUnit = new FcUnit();
                fcUnit.setBuildingCode(unitMessage.getBuildingCode());
                fcUnit.setUnitCode(unitMessage.getBuildingCode() + "-U" + i);
                fcUnit.setUnitName("第" + i + "单元");
                fcUnitMapper.insert(fcUnit);
                fcUnitList.add(fcUnit);
            }
        }
        return fcUnitList;
    }

    public Integer updateUnit(FcUnit fcUnit) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("id", fcUnit.getId());
        return fcUnitMapper.update(fcUnit, updateWrapper);
    }

    public List<FcCell> insertCell(CellMessage[] cellMessages) {
        List<FcCell> cells = new ArrayList<>();
        for (CellMessage cellMessage : cellMessages) {
            for (int i = cellMessage.getStartFloor(); i <= cellMessage.getStopFloor(); i++) {
                for (int j = cellMessage.getStartCellId(); j <= cellMessage.getStopCellId(); j++) {
                    FcCell fcCell = new FcCell();
                    fcCell.setUnitCode(cellMessage.getUnitCode());
                    fcCell.setCellCode("C" + j);
                    fcCell.setCellName(i + "-" + j);
                    fcCell.setFloorNumber(i);
                    fcCellMapper.insert(fcCell);
                    cells.add(fcCell);
                }
            }
        }
        return cells;
    }

    public List<FcBuilding> selectBuildingsByEstateCode(String estateCode) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("estate_code",estateCode);
        return fcBuildingMapper.selectList(qw);
    }

    public List<FcUnit> selectUnitByBuildingCode(String buildingCode) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("building_code",buildingCode);
        return fcUnitMapper.selectList(qw);
    }

    public List<FcCell> selectCellByUnitCode(String unitCode) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("unit_code",unitCode);
        return fcCellMapper.selectList(qw);
    }

    public Integer updateCell(FcCell fcCell) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("id", fcCell.getId());
        return fcCellMapper.update(fcCell, updateWrapper);
    }

    public List<FcEstate> selectEstate(String company) {
        QueryWrapper<FcEstate> qw = new QueryWrapper<>();
        qw.eq("company",company);
        return fcEstateMapper.selectList(qw);
    }
}
