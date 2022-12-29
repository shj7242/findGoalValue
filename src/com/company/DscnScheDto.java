package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DscnScheDto {

    private LocalDate scheYmd;
    private LocalDate intStartYmd;
    private LocalDate intEndYmd;
    private long intCnts;
    private BigDecimal faceIntAmt;
    private BigDecimal efctIrt;
    private BigDecimal efctIntAmt;
    private BigDecimal bfrDscnAmt;
    private BigDecimal dscnTgtAmt;
    private BigDecimal aftDscnAmt;

    public DscnScheDto(LocalDate scheYmd, LocalDate intStartYmd, LocalDate intEndYmd, long intCnts, BigDecimal faceIntAmt, BigDecimal efctIrt, BigDecimal efctIntAmt, BigDecimal bfrDscnAmt, BigDecimal dscnTgtAmt, BigDecimal aftDscnAmt) {
        this.scheYmd = scheYmd;
        this.intStartYmd = intStartYmd;
        this.intEndYmd = intEndYmd;
        this.intCnts = intCnts;
        this.faceIntAmt = faceIntAmt;
        this.efctIrt = efctIrt;
        this.efctIntAmt = efctIntAmt;
        this.bfrDscnAmt = bfrDscnAmt;
        this.dscnTgtAmt = dscnTgtAmt;
        this.aftDscnAmt = aftDscnAmt;
    }

    @Override
    public String toString() {
        return "DscnScheDto{" +
                "scheYmd=" + scheYmd +
                ", intStartYmd=" + intStartYmd +
                ", intEndYmd=" + intEndYmd +
                ", intCnts=" + intCnts +
                ", faceIntAmt=" + faceIntAmt +
                ", efctIrt=" + efctIrt +
                ", efctIntAmt=" + efctIntAmt +
                ", bfrDscnAmt=" + bfrDscnAmt +
                ", dscnTgtAmt=" + dscnTgtAmt +
                ", aftDscnAmt=" + aftDscnAmt +
                '}';
    }

    public void setScheYmd(LocalDate scheYmd) {
        this.scheYmd = scheYmd;
    }

    public void setIntStartYmd(LocalDate intStartYmd) {
        this.intStartYmd = intStartYmd;
    }

    public void setIntEndYmd(LocalDate intEndYmd) {
        this.intEndYmd = intEndYmd;
    }

    public void setIntCnts(long intCnts) {
        this.intCnts = intCnts;
    }

    public void setFaceIntAmt(BigDecimal faceIntAmt) {
        this.faceIntAmt = faceIntAmt;
    }

    public void setEfctIrt(BigDecimal efctIrt) {
        this.efctIrt = efctIrt;
    }

    public void setEfctIntAmt(BigDecimal efctIntAmt) {
        this.efctIntAmt = efctIntAmt;
    }

    public void setBfrDscnAmt(BigDecimal bfrDscnAmt) {
        this.bfrDscnAmt = bfrDscnAmt;
    }

    public void setDscnTgtAmt(BigDecimal dscnTgtAmt) {
        this.dscnTgtAmt = dscnTgtAmt;
    }

    public void setAftDscnAmt(BigDecimal aftDscnAmt) {
        this.aftDscnAmt = aftDscnAmt;
    }

    public LocalDate getScheYmd() {
        return scheYmd;
    }

    public LocalDate getIntStartYmd() {
        return intStartYmd;
    }

    public LocalDate getIntEndYmd() {
        return intEndYmd;
    }

    public long getIntCnts() {
        return intCnts;
    }

    public BigDecimal getFaceIntAmt() {
        return faceIntAmt;
    }

    public BigDecimal getEfctIrt() {
        return efctIrt;
    }

    public BigDecimal getEfctIntAmt() {
        return efctIntAmt;
    }

    public BigDecimal getBfrDscnAmt() {
        return bfrDscnAmt;
    }

    public BigDecimal getDscnTgtAmt() {
        return dscnTgtAmt;
    }

    public BigDecimal getAftDscnAmt() {
        return aftDscnAmt;
    }
}
