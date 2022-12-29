package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalIrt {

    public BigDecimal calIrt(BigDecimal x) {

        List<DscnScheDto> 상각스케줄목록 = getDscnSche();
        BondBaseDto 채권매입정보 = getBondBase();
        BigDecimal 액면금액 = 채권매입정보.getFaceAmt();
        BigDecimal 액면이자율 = 채권매입정보.getFaceIrt();
        BigDecimal 매입금액 = 채권매입정보.getBuyAmt();
        LocalDate 매입일자 = 채권매입정보.getContYmd();
        BigDecimal 상각전장부가 = BigDecimal.ZERO;
        BigDecimal 액면이자 = BigDecimal.ZERO;
        BigDecimal 유효이자 = BigDecimal.ZERO;
        BigDecimal 상각대상금액 = BigDecimal.ZERO;
        BigDecimal 상각후장부가 = BigDecimal.ZERO;
        BigDecimal 유효이자율 = x;
        for(int i = 0; i < 상각스케줄목록.size(); i ++){
            DscnScheDto 상각스케줄 = 상각스케줄목록.get(i);
            //최초 스케줄 조정(경과 분이 있는 경우)
            long 이자일수 = 상각스케줄목록.get(i).getIntCnts();

            if(상각스케줄목록.get(i).getIntStartYmd().isBefore(매입일자)&&상각스케줄목록.get(i).getIntEndYmd().isAfter(매입일자)){

                long 경과일수 = 채권매입정보.getContYmd().compareTo(상각스케줄목록.get(i).getIntStartYmd());
                long 상각일수 = 이자일수 - 경과일수;

                //상각 시작일 설정
                상각스케줄.setIntStartYmd(getBondBase().getContYmd());
                상각스케줄.setIntCnts(상각일수);

                //액면 이자
                BigDecimal 액면이자_경과이자제외 = 액면금액.multiply(액면이자율).multiply(new BigDecimal(상각일수)).divide(new BigDecimal(365), BigDecimal.ROUND_CEILING);
                액면이자_경과이자제외 = 액면이자_경과이자제외.setScale(0, BigDecimal.ROUND_CEILING);

                //상각 전 장부가
                상각전장부가 = 채권매입정보.getBuyAmt();

                //유효 이자
                유효이자 = 상각전장부가.multiply(유효이자율).multiply(new BigDecimal(상각일수)).divide(new BigDecimal(365), BigDecimal.ROUND_CEILING);
                유효이자 = 유효이자.setScale(0, BigDecimal.ROUND_CEILING);

                //상각 대상 금액
                상각대상금액 = 유효이자.subtract(액면이자_경과이자제외);

                //상각 후 장부가
                상각후장부가 = 상각전장부가.add(상각대상금액);

                상각스케줄.setFaceIntAmt(액면이자_경과이자제외);
                상각스케줄.setBfrDscnAmt(상각전장부가);
                상각스케줄.setAftDscnAmt(상각후장부가);
                상각스케줄.setDscnTgtAmt(상각대상금액);
                상각스케줄.setEfctIrt(유효이자율);
                상각스케줄.setEfctIntAmt(유효이자);
                상각스케줄목록.remove(i);
                상각스케줄목록.add(i, 상각스케줄);
                상각전장부가 = 상각후장부가;

            }else{
                if(!상각전장부가.equals(BigDecimal.ZERO)){

                    액면이자 = 액면금액.multiply(액면이자율).multiply(new BigDecimal(이자일수)).divide(new BigDecimal(365), BigDecimal.ROUND_CEILING);
                    액면이자 = 액면이자.setScale(0, BigDecimal.ROUND_CEILING);

                    유효이자 = 상각전장부가.multiply(유효이자율).multiply(new BigDecimal(이자일수)).divide(new BigDecimal(365), BigDecimal.ROUND_CEILING);
                    유효이자 = 유효이자.setScale(0, BigDecimal.ROUND_CEILING);

                    상각대상금액 = 유효이자.subtract(액면이자);

                    상각후장부가 = 상각전장부가.add(상각대상금액);

                    상각스케줄.setFaceIntAmt(액면이자);
                    상각스케줄.setEfctIrt(유효이자율);
                    상각스케줄.setEfctIntAmt(유효이자);
                    상각스케줄.setBfrDscnAmt(상각전장부가);
                    상각스케줄.setAftDscnAmt(상각후장부가);
                    상각스케줄.setDscnTgtAmt(상각대상금액);
                    상각스케줄목록.remove(i);
                    상각스케줄목록.add(i, 상각스케줄);
                    상각전장부가 = 상각후장부가;
                }

            }
            System.out.println(상각스케줄목록.get(i).toString());
        }

        return 상각후장부가.subtract(액면금액);
    }

    public BondBaseDto getBondBase(){

        return new BondBaseDto(LocalDate.of(2021, 2, 15), LocalDate.of(2022, 1, 5),new BigDecimal(1000000), new BigDecimal(995000), new BigDecimal(0.023).setScale(3, BigDecimal.ROUND_UP));

    }

    public List<DscnScheDto> getDscnSche() {

        List<DscnScheDto> list = new ArrayList<DscnScheDto>();
        list.add(new DscnScheDto(LocalDate.of(2021, 4, 5), LocalDate.of(2021, 1, 5), LocalDate.of(2021, 4, 5), 90, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO));
        list.add(new DscnScheDto(LocalDate.of(2021, 7, 5), LocalDate.of(2021, 4, 6), LocalDate.of(2022, 7, 5), 91, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO));
        list.add(new DscnScheDto(LocalDate.of(2021, 10, 5), LocalDate.of(2022, 7, 5), LocalDate.of(2022, 10, 5), 92, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO));
        list.add(new DscnScheDto(LocalDate.of(2022, 1, 5), LocalDate.of(2022, 10, 5), LocalDate.of(2022, 1, 5), 92, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO));

        return list;


    }
}
