package com.base.proxy.staticc.extend;

import java.util.Date;

public class TimeSale extends Sale{
    @Override
    public void sale() {
        System.out.println("进门时刻：" + new Date());
        super.sale();
        System.out.println("出门时刻：" + new Date());
    }
}
