package com.section.adapter.demo;

/**
 * @Desc: 验货单Bean
 * @Author: hkk
 * @Date: 2023/8/29
 */
public class CheckMaterialBean {
    /**
     * 查验类型
     * 1储运查验
     * 2原材料检查
     * 3sku检查
     */
    private int inspectionType;

    /**
     * 查验内容类型
     * car_inspection 配送车辆、盛装容器是否清洁消毒？
     * temperature_inspection 温度、湿度、光照条件是否符合要求？
     * quarantine_inspection 不同类型食品原料与毒害物品是否隔离分装？
     * retained_inspection 随货证明文件是否留存？
     * consistency_inspection 单据与实物的品种、品质是否一致？
     * corrupt_inspection 是否有腐败变质、霉变生虫等现象？
     * smell_inspection 是否有污秽不洁、散发异味等现象？
     * trademark_inspection 是否有掺杂掺假、标识不符等现象？
     * source_inspection 是否有禁食物种、来源不明等现象？
     * validity_inspection 是否有超温暴露、效期过保等现象？
     */
    private String inspectionContentType;

    private String inspectionContent;

    /**
     * 是否通过
     * 0未通过，1通过，inspectionType=3，可忽略
     */
    private int isInspection;

    //skuId
    private long stuffSkuId;

    //图片url
    private String skuImageUrl;

    //备注
    private String remark;

    public CheckMaterialBean(int inspectionType, String inspectionContentType) {
        this.inspectionType = inspectionType;
        this.inspectionContentType = inspectionContentType;
        this.inspectionContent = InspectionEnum.getTypeContent(inspectionContentType);
    }

    public int getInspectionType() {
        return inspectionType;
    }

    public void setInspectionType(int inspectionType) {
        this.inspectionType = inspectionType;
    }

    public String getInspectionContentType() {
        return inspectionContentType;
    }

    public void setInspectionContentType(String inspectionContentType) {
        this.inspectionContentType = inspectionContentType;
    }

    public String getInspectionContent() {
        return inspectionContent;
    }

    public void setInspectionContent(String inspectionContent) {
        this.inspectionContent = inspectionContent;
    }

    public int getIsInspection() {
        return isInspection;
    }

    public void setIsInspection(int isInspection) {
        this.isInspection = isInspection;
    }

    public long getStuffSkuId() {
        return stuffSkuId;
    }

    public void setStuffSkuId(long stuffSkuId) {
        this.stuffSkuId = stuffSkuId;
    }

    public String getSkuImageUrl() {
        return skuImageUrl;
    }

    public void setSkuImageUrl(String skuImageUrl) {
        this.skuImageUrl = skuImageUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "CheckMaterialBean{" +
                "inspectionType=" + inspectionType +
                ", inspectionContentType='" + inspectionContentType + '\'' +
                ", inspectionContent='" + inspectionContent + '\'' +
                ", isInspection=" + isInspection +
                ", stuffSkuId=" + stuffSkuId +
                ", skuImageUrl='" + skuImageUrl + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
