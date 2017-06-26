package com.sda.chat;

import java.util.HashMap;
import java.util.Map;

public class ChatUsersStorage {
    private Map<String, ChatConnectionFacade> users;

    public ChatUsersStorage() {
        users = new HashMap<>();
    }

    public boolean add(String nickName, ChatConnectionFacade user) {
        boolean flag = false;
        if (!users.containsKey(nickName)) {
            users.put(nickName, user);
            flag = true;
        }
        return flag;
    }

    public ChatConnectionFacade get(String nickName) {
        return users.get(nickName);
    }


}
