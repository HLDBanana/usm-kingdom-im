/*
 * Copyright (c) 2017 Baidu, Inc. All Rights Reserve.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.powernow.usm.common;


import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * WorkerNodeType
 * <li>CONTAINER: Such as Docker
 * <li>ACTUAL: Actual machine
 *
 */
public enum DealTypeRecordEnum {

    对战(1,"tb_challenge"),升级(2,"tb_monster_upper"),充值(3,"tb_pay_order"),提取(4,"tb_pay_order"),合成(6,"tb_backpack_record"),开蛋(7,""),游戏购买NFT(8, "tb_nft_token_sale"),游戏出售NFT(9,""),锁仓(10,"");
    /**
     * Lock type
     */
    @EnumValue
    public Integer type;
    public String tb;

    /**
     * Constructor with field of type
     */
    private DealTypeRecordEnum(Integer type, String tb) {
        this.type = type;
        this.tb = tb;
    }

    public static DealTypeRecordEnum getByType(Integer type) {
        DealTypeRecordEnum[] values = DealTypeRecordEnum.values();
        for (DealTypeRecordEnum recordType : values) {
            if(recordType.type.intValue()==type.intValue()){
                return recordType;
            }
        }
        return null;
    }
}
