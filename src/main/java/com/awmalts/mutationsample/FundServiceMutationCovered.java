package com.awmalts.mutationsample;

public class FundServiceMutationCovered {

    private int unitsOnHand;
    private int units;

    private  double fund_nav = 0.00;
    private double NAV = 0.00;
    private double min_amount;

    public FundServiceMutationCovered(int unitsOnHand) {
        this.unitsOnHand = unitsOnHand;
    }


    public boolean isValidAmount(double amount, int fund_num) {
        min_amount = 0.00;

        if (fund_num == 1 || fund_num == 2)  {
            min_amount = 500.00;
            if (amount < min_amount){
                return false;
            }else {
                return true;
            }
        }

        if (fund_num == 3) {
            min_amount = 1000.00;
            if (amount < min_amount){
                return false;
            }else {
                return true;
            }
        }


        return false;
    }


    private double fund_NAV_Value(int fund_num) {

        if (fund_num == 1) {
            NAV = 10.00;
        }
        if (fund_num == 2) {
            NAV = 20.00;
        }
        if (fund_num == 3) {
            NAV = 25.00;
        }

       return NAV;
    }

    public int purchaseFundUnits(double amount, int fund_num) {

        if (isValidAmount(amount,fund_num)){
            fund_nav = fund_NAV_Value(fund_num);
            units = (int) (amount/fund_nav);
            unitsOnHand = unitsOnHand + units;
            return unitsOnHand;
        }


        return 0;

    }

    public int redeemFundUnits(double amount, int fund_num) {


        if (isValidAmount(amount,fund_num)){
            fund_nav = fund_NAV_Value(fund_num);
            units = (int) (amount/fund_nav);
            int checkUnitsOnHand = unitsOnHand - units;

            if (checkUnitsOnHand == 0) {
                unitsOnHand =  0;

            } else {
                unitsOnHand = checkUnitsOnHand;
                return unitsOnHand;
            }
         }
        return unitsOnHand;
    }

}

