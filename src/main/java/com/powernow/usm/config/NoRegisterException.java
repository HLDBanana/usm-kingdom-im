package com.powernow.usm.config;


import com.powernow.usm.common.CommonEnum;
import lombok.Data;

/**
 * @description: 未注册异常
 * @create: 2020/3/24 13:09
 * @update: 2020/3/24 13:09
 */
@Data
public class NoRegisterException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 描述：错误码
     */
    private int errorCode;

    /**
     * 描述：错误信息
     */
    private String errorMsg;

    public NoRegisterException() {
    }

    public NoRegisterException(CommonEnum commonEnum) {
        super(String.valueOf(commonEnum.getCode()));
        this.errorCode = commonEnum.getCode();
        this.errorMsg = commonEnum.getMsg();
    }

    public NoRegisterException(CommonEnum commonEnum, Throwable cause) {
        super(String.valueOf(commonEnum.getCode()), cause);
        this.errorCode = commonEnum.getCode();
        this.errorMsg = commonEnum.getMsg();
    }

    public NoRegisterException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public NoRegisterException(int errorCode, String errorMsg) {
        super(String.valueOf(errorCode));
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public NoRegisterException(int errorCode, String errorMsg, Throwable cause) {
        super(String.valueOf(errorCode), cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
