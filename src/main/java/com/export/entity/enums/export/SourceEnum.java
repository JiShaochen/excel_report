package com.export.entity.enums.export;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author JiShaochen
 * @date 2019/8/9 10:14
 * @desc
 */
public enum SourceEnum {
    WE_CHAT("微信"),BOOK("人民日报");
    private String value;
    SourceEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
