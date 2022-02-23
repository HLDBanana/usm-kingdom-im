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
public enum PayTypeEnum {

    充值UU(1,""),充值药水(2,""),充值黄钻(3,""),充值紫钻(4,""),充值元兽蛋(5,""),充值元兽(6,""),元兽发放(7,""),
    提取药水(-2,"tb_backpack_record"),提取黄钻(-3,"tb_backpack_record"),提取紫钻(-4,"tb_backpack_record"),提取元兽蛋(-5,"tb_backpack_record"),提取元兽(-6,"tb_nft_token");

    /**
     * Lock type
     */
    @EnumValue
    public Integer type;
    public String tb;

    /**
     * Constructor with field of type
     */
    private PayTypeEnum(Integer type, String tb) {
        this.type = type;
        this.tb = tb;
    }

    public static PayTypeEnum getByType(Integer type) {
        PayTypeEnum[] values = PayTypeEnum.values();
        for (PayTypeEnum recordType : values) {
            if(recordType.type.intValue()==type.intValue()){
                return recordType;
            }
        }
        return null;
    }
}
