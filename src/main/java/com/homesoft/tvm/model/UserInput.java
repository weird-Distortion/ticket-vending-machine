package com.homesoft.tvm.model;

import java.util.ArrayList;
import java.util.List;

public class UserInput {

    private List<String> userInputList;

    public UserInput() {
        this.userInputList = new ArrayList<>();
    }

    public void insertNewCoin(String coinValue) {
        assert coinValue != null : "coinValue is Null";
        userInputList.add(coinValue);
    }

    public List<String> getUserInputList() {
        return userInputList;
    }

    public void setUserInputList(List<String> userInputList) {
        this.userInputList = userInputList;
    }
}
