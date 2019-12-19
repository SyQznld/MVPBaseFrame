package com.appler.mvpbaseframe.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by appler on 2018/9/18.
 */

@Entity
public class UserData {
    @Id
    private Long id;
    private String name;
    private String telPhoneNumber;
    @Generated(hash = 676776946)
    public UserData(Long id, String name, String telPhoneNumber) {
        this.id = id;
        this.name = name;
        this.telPhoneNumber = telPhoneNumber;
    }
    @Generated(hash = 1838565001)
    public UserData() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTelPhoneNumber() {
        return this.telPhoneNumber;
    }
    public void setTelPhoneNumber(String telPhoneNumber) {
        this.telPhoneNumber = telPhoneNumber;
    }

}
