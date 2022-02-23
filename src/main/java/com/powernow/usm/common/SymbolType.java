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


/**
 * WorkerNodeType
 * <li>CONTAINER: Such as Docker
 * <li>ACTUAL: Actual machine
 *
 */
public enum SymbolType {

    Potion(1, "Potion"),
    YDiamond(2, "YDiamond"),
    PDiamond(3, "PDiamond"),
    Metamon(4, "Metamon"),
    Egg(5, "Egg"),
    MPB(6, "MPB"),
    RACAPunk(7, "RACAPunk"),
    MML(8, "MML"),
    BMM(9, "BMM");

    public Integer key;
    public String value;

    SymbolType(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getValue(int i) {
        SymbolType[] values = SymbolType.values();
        for (SymbolType val : values) {
            if (val.key == i) {
                return val.value;
            }
        }
        return null;
    }

    public static SymbolType getByType(int i) {
        SymbolType[] values = SymbolType.values();
        for (SymbolType val : values) {
            if (val.key == i) {
                return val;
            }
        }
        return null;
    }
}

