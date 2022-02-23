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
public enum BackpackType {

    元兽(0),碎片(1),药水(2),黄钻(3),紫钻(4),UU(5),元兽蛋(6);

    /**
     * Lock type
     */
    @EnumValue
    public Integer type;

    /**
     * Constructor with field of type
     */
    private BackpackType(Integer type) {
        this.type = type;
    }

    public static BackpackType getByType(Integer type) {
        BackpackType[] values = BackpackType.values();
        for (BackpackType recordType : values) {
            if(recordType.type.intValue()==type.intValue()){
                return recordType;
            }
        }
        return null;
    }
}
