package com.market.bean.po;
import java.sql.Date;
import java.sql.Timestamp;
public class Log {
    private Integer logId;
    private String logName;
    private String logOps;
    private Timestamp logTime;

    public Log() {
    }
    public Log(Integer logId,String logName,String logOps,Timestamp logTime) {
        this.logId = logId;
        this.logName = logName;
        this.logOps = logOps;
        this.logTime = logTime;
    }


    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getLogOps() {
        return logOps;
    }

    public void setLogOps(String logOps) {
        this.logOps = logOps;
    }

    public Timestamp getLogTime() {
        return logTime;
    }

    public void setLogTime(Timestamp logTime) {
        this.logTime = logTime;
    }
}
