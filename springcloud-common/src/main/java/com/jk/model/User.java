package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User  implements Serializable {
    private Integer userId;
    private String  userName;
    private String userzhi;
    private String userPwd;
    private String userbu;
    private String userPrice;
    private String userzuo;

    private String zhiname;
    private String buname;
    /*userId
            userName
    userzhi
            userPwd
    userbu
            userPrice
    userzuo
*/
}
