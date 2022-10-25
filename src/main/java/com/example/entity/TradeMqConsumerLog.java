package com.example.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TradeMqConsumerLog  {
    private String msgId;

    private String msgBody;

    private Integer consumerStatus;

    private Integer consumerTimes;

    private Date consumerTimestamp;

    private String remark;
    private String groupName;

    private String msgTag;

    private String msgKey;

    private String lid;
}