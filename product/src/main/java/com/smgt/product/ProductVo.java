package com.smgt.product;

import lombok.Data;

@Data
public class ProductVo {
    int sno; //정수
    String code; //문자열
    String codeName;
    String nal;
    long ea;  //소수점 가능
    long price;
    long amt;    
}
