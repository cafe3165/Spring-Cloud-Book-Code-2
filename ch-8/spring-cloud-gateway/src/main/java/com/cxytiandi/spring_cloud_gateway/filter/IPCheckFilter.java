package com.cxytiandi.spring_cloud_gateway.filter;

import com.cxytiandi.spring_cloud_gateway.Utils.JsonUtils;
import com.cxytiandi.spring_cloud_gateway.base.ResponseData;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Author:cafe3165
 * Date:2020-06-01
 */
public class IPCheckFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        return null;
        HttpHeaders headers = exchange.getRequest().getHeaders();
        if (getIp(headers).equals("127.0.0.1")) {
            ServerHttpResponse response = exchange.getResponse();
            ResponseData data = new ResponseData();
            data.setCode(401);
            data.setMessage("非法请求");
//            byte[] datas= JsonUtils.toJson(data);
        }
        return null;
    }

    private String getIp(HttpHeaders httpHeaders) {
        return "127.0.0.1";

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
