package com.section.adapter.demo;

/**
 * @Desc:
 * @Author: hkk
 * @Date: 2023/8/29
 */
public enum InspectionEnum {

    CAR_INSPECTION("car_inspection", "1.配送车辆、盛装容器是否清洁消毒？"),
    TEMPERATURE_INSPECTION("temperature_inspection", "2.温度、湿度、光照条件是否符合要求？"),
    QUARANTINE_INSPECTION("quarantine_inspection", "3.不同类型食品原料与毒害物品是否隔离分装？"),
    RETAINED_INSPECTION("retained_inspection", "4.随货证明文件是否留存？"),
    CONSISTENCY_INSPECTION("consistency_inspection", "5.单据与实物的品种、品质是否一致？"),
    CORRUPT_INSPECTION("corrupt_inspection", "6.是否有腐败变质、霉变生虫等现象？"),
    SMELL_INSPECTION("smell_inspection", "7.是否有污秽不洁、散发异味等现象？"),
    TRADEMARK_INSPECTION("trademark_inspection", "8.是否有掺杂掺假、标识不符等现象？"),
    SOURCE_INSPECTION("source_inspection", "9.是否有禁食物种、来源不明等现象？"),
    VALIDITY_INSPECTION("validity_inspection", "10.是否有超温暴露、效期过保等现象？");

    private String type;
    private String content;

    private InspectionEnum(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public static String getTypeContent(String type) {
        for (InspectionEnum inspection: InspectionEnum.values()) {
            if (inspection.getType().equals(type)) {
                return inspection.content;
            }
        }
        return "";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
