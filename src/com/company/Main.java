package com.company;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        CalIrt 목표값찾기 = new CalIrt();
        BigDecimal 목표값 = BigDecimal.ZERO;
        BigDecimal 최소값 = new BigDecimal(0);
        BigDecimal 최댓값 = new BigDecimal(1);
        BigDecimal 목표값_최소 = BigDecimal.ZERO;
        BigDecimal 목표값_최대 = BigDecimal.ZERO;
        //최대 n번 반복
        int n = 100;
        int cnts = 0;
        for(int i = 0; i < n; i ++){

            BigDecimal 중앙값 = BigDecimal.ZERO;
            목표값_최소 = 목표값찾기.calIrt(최소값);
            목표값_최대 = 목표값찾기.calIrt(최댓값);
            중앙값 = 최소값.add(최댓값).divide(new BigDecimal(2));
            if(목표값_최소.abs().compareTo(목표값_최대.abs()) >= 0){
                최소값 = 중앙값;
            }else{
                최댓값 = 중앙값;
            }
            if(목표값_최소.equals(목표값_최대)&&목표값_최소.equals(BigDecimal.ZERO)){
                목표값 = 최댓값;
                cnts = i;
                break;
            }
        }
        System.out.println((cnts +1) +"번 반복하여 값을 찾음");
        System.out.println("산출된 목표값(해) :" + 목표값.setScale(6, BigDecimal.ROUND_CEILING));
    }
}
