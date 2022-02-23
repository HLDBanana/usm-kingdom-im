package com.powernow.usm.common;

public enum ErrorEnum {
    FAIL("failed"),
    REPEAT_FAIL("Please don't repeat the operation."),
    USER_ADDRESS_ERROR("The user's account is invalid."),
    UPDATE_LEVEL_FAIL("Level up failed, {} props are insufficient."),
    LEVLE_MAX_MONSTER_NOT_UPDATE("It is currently the highest level and cann't be level uped."),
    FRAGMENT_NOT_ENOUGH_NOT_COMPOST_MONSTER("You don't have enough Metamon fragments to mint Metamon egg."),
    BATTLE_NOPAY("Sorry, you don't have enough UU to battle."),
    MONSTER_ERROR("Metamon error"),
    MONSTER_TEAR_ERROR("The fighting Metamon don't have enough Energy."),
    PARAM_IS_NULL("Parameter cann't be empty."),
    NOT_BELONG_FRONT("The level of Metamon doesn't match the selected battlefield."),
    FUNCTION_NO_OPEN("Temporarily closed.  Please pay attention to the notice for the reopen time."),
    EGG_NOT_EXIST("Metamon egg does not exist"),
    ACCESS_TOKEN_ERROR("The user token is invalid. Please log in again."),
    EGG_NUM_ERROR("Metamon egg insufficient"),
    POTION_NUM_ERROR("Potion insufficient"),
    YDIAMOND_NUM_ERROR("Yellow diamond insufficient"),
    PDIAMOND_NUM_ERROR("Purple diamond insufficient"),
    OPEN_EGG_ERROR("Open egg failed"),
    ORDER_IS_NULL("Transaction does not exist"),
    ORDER_IS_COMPELTE_TO_CANCEL("Transaction finished already, can't be cancelled"),
    ORDER_IS_CANCEL_TO_CANCEL("Transaction cancelld already, don't repeat  operation"),
    ORDER_NOT_TO_CANCEL(" Transaction does not meet cancel conditions"),
    ORDER_NOT_TO_CANCEL_EXCEPTION("Transaction does not meet cancel conditions，{}"),
    NOT_TEST_USER_TO_LOGIN("Is not open. You are not allow  to log in currently"),
    MONSTER_TRANSFER_OUT("Metamon transferred out,can't battle"),
    UU_ERROR("you don't have enough u-RACA."),
    WITHDRAW_NO_OPEN("Unable to withdraw. Please pay attention to the notice when the withdraw is reopen."),
    SERVICE_STOP("In maintain. Please pay attention to the notice for the reopen time. "),
    SHOP_ORDER_NULL("This order does not exist."),
    SHOP_ORDER_SOLD("This order has been completed."),
    SHOP_ORDER_CANCELED("This order has been cancelled."),
    SHOP_ORDER_STATUS_UPDATE_ERROR("This order has been sold or cancelled."),
    ITEM_NUM_ERROR("Insufficient quantity."),
    SHOP_ORDER_OWNER_SELF("You cannot purchase orders from your own inventory."),
    U_USM_NUM_ERROR("U-USM insufficient"),
    V_CONCERT_NUM_ERROR("V-CONCERT insufficient"),
    Donuts_NUM_ERROR("Donuts insufficient")
    ;

    public String text;

    ErrorEnum(String text) {
        this.text = text;
    }
}
