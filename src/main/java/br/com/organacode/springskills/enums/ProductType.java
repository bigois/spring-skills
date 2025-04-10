package br.com.organacode.springskills.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductType {
    KT("KIT"),
    LP("LABOR FORCE"),
    RW("RAW MATERIAL"),
    FP("FINISHED PRODUCT"),
    IP("INTERMEDIATE PRODUCT"),
    SV("SERVICE"),
    GN("GENERIC");

    private final String description;
}
