package com.example.liyanqiang.myapplication.model;

import java.util.List;

public class ItemHome {
    private int label;
    private  String title;
    private  String number;
    private  String money;

    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private List<ItemHomePerson> list;

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public List<ItemHomePerson> getList() {
        return list;
    }

    public void setList(List<ItemHomePerson> list) {
        this.list = list;
    }
}
