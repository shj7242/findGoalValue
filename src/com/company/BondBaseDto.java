package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BondBaseDto {
    private LocalDate contYmd;
    private LocalDate maturityYmd;

    private BigDecimal faceAmt;
    private BigDecimal buyAmt;
    private BigDecimal faceIrt;

    @Override
    public String toString() {
        return "BondBaseDto{" +
                "contYmd=" + contYmd +
                ", maturityYmd=" + maturityYmd +
                ", faceAmt=" + faceAmt +
                ", buyAmt=" + buyAmt +
                ", faceIrt=" + faceIrt +
                '}';
    }

    public BondBaseDto(LocalDate contYmd, LocalDate maturityYmd, BigDecimal faceAmt, BigDecimal buyAmt, BigDecimal faceIrt) {
        this.contYmd = contYmd;
        this.maturityYmd = maturityYmd;
        this.faceAmt = faceAmt;
        this.buyAmt = buyAmt;
        this.faceIrt = faceIrt;
    }

    public void setContYmd(LocalDate contYmd) {
        this.contYmd = contYmd;
    }

    public void setMaturityYmd(LocalDate maturityYmd) {
        this.maturityYmd = maturityYmd;
    }

    public void setFaceAmt(BigDecimal faceAmt) {
        this.faceAmt = faceAmt;
    }

    public void setBuyAmt(BigDecimal buyAmt) {
        this.buyAmt = buyAmt;
    }

    public void setFaceIrt(BigDecimal faceIrt) {
        this.faceIrt = faceIrt;
    }

    public LocalDate getContYmd() {
        return contYmd;
    }

    public LocalDate getMaturityYmd() {
        return maturityYmd;
    }

    public BigDecimal getFaceAmt() {
        return faceAmt;
    }

    public BigDecimal getBuyAmt() {
        return buyAmt;
    }

    public BigDecimal getFaceIrt() {
        return faceIrt;
    }
}
