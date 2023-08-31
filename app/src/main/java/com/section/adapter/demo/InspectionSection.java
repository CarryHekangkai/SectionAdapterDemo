package com.section.adapter.demo;

import com.chad.library.adapter.base.entity.JSectionEntity;

/**
 * @Desc:
 * @Author: hkk
 * @Date: 2023/8/29
 */
public class InspectionSection extends JSectionEntity {

    private CheckMaterialBean checkMaterialBean;

    public InspectionSection(CheckMaterialBean checkMaterialBean) {
        this.checkMaterialBean = checkMaterialBean;
    }

    public CheckMaterialBean getCheckMaterialBean() {
        return checkMaterialBean;
    }

    @Override
    public boolean isHeader() {
        return checkMaterialBean.getInspectionType() == 0;
    }

    @Override
    public String toString() {
        return "InspectionSection{" +
                "checkMaterialBean=" + checkMaterialBean +
                '}';
    }
}
