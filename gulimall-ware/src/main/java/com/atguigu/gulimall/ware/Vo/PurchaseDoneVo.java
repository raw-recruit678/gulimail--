package com.atguigu.gulimall.ware.Vo;


import lombok.Data;

import java.util.List;

@Data
public class PurchaseDoneVo {
    private Long id; // 采购单id

    private List<PurchaseItemDoneVo> items;
}
