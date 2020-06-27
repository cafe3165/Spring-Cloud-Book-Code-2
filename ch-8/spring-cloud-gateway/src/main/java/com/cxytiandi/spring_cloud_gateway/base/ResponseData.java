package com.cxytiandi.spring_cloud_gateway.base;

/**
 * Author:cafe3165
 * Date:2020-06-01
 */
import lombok.Data;

@Data
public class ResponseData {

    private Boolean status = true;
    private int code = 200;
    private String message = "";
    private Object data;

}