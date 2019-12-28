package com.base.proxy.staticc.extend;

public class HelloTimeSale extends TimeSale {
    @Override
    public void sale() {
        System.out.println("欢迎光临");
        super.sale();
        System.out.println("下次再来");
    }
}
