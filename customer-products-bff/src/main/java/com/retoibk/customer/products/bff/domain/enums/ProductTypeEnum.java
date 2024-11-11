package com.retoibk.customer.products.bff.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum ProductTypeEnum {

    DC ("DC","DEBIT_CARD"),
    CC ("CC","CREDIT_CARD");

    private static final Map<String, String> mapKeyValue = new HashMap<>();

    static {
        for (ProductTypeEnum productTypeEnum :values()) {
            mapKeyValue.put(productTypeEnum.name, productTypeEnum.value);
        }
    }

    private final String name;
    private final String value;

    public static String getDocumentTypeEnumByValue(String name) {return mapKeyValue.get(name);}
}
