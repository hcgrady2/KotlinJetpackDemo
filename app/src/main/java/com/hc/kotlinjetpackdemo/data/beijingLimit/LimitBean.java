package com.hc.kotlinjetpackdemo.data.beijingLimit;

import java.util.List;

/**
 * @Author: wanghaichao
 * @Date: 2023/9/7
 * @Description:
 * @Copyright: all rights reserved.
 */
public class LimitBean {

    private Integer code;
    private List<DataDTO> data;
    private String msg;

    public static class DataDTO {
        private String text;
        private String longitude;
        private String latitude;
        private String createTime;
        private Integer type;
        private String updateTime;
        private String updateData;
        private Integer cid;
    }
}
