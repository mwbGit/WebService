package com.mwb.data.dao.module;

import com.mwb.web.framework.i18n.EnumMessageTranslator;
import com.mwb.web.framework.mybatis.typehandler.IdInterface;

import java.util.HashMap;
import java.util.Map;

public enum UserStatus implements IdInterface {
    ACTIVE(1, "ACTIVE", "Active"),
    LOCKED(2, "LOCKED", "Locked"),
    SUSPENDED(3, "SUSPENDED", "Suspended");
	
    private static final Map<String, UserStatus> code2UserStatus;
    private static final Map<Integer, UserStatus> id2UserStatus;

    private final int id;
    private final String code;
    private final String description;
    
    static {
        code2UserStatus = new HashMap<String, UserStatus>();
        id2UserStatus = new HashMap<Integer, UserStatus>();
        
        for (UserStatus userStatus : UserStatus.values()) {
            code2UserStatus.put(userStatus.getCode(), userStatus);
            id2UserStatus.put(userStatus.getId(), userStatus);
        }
    }

    public static UserStatus fromCode(String code) {
        return code2UserStatus.get(code);
    }
    
    public static UserStatus fromId(int id) {
        return id2UserStatus.get(id);
    }

    UserStatus(int id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    @Override
	public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

	public String getName() {
        return EnumMessageTranslator.getName(getClass().getSimpleName() + "." + code);
    }
}
