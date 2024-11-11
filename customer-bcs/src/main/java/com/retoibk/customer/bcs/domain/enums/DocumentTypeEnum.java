package com.retoibk.customer.bcs.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum DocumentTypeEnum {

    DNI ("DNI","01","8","8"),
    RUC ("RUC","02","11","11"),
    CE ("CE","03","1","12");

    private static final Map<String, String> mapKeyValue = new HashMap<>();

    static {
        for (DocumentTypeEnum documentTypeEnum :values()) {
            mapKeyValue.put(documentTypeEnum.name, documentTypeEnum.value);
        }
    }

    private final String name;
    private final String value;
    private final String min;
    private final String max;

    public static String getDocumentTypeEnumByValue(String name) {return mapKeyValue.get(name);}
}
