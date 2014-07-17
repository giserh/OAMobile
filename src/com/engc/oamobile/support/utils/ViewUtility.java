package com.engc.oamobile.support.utils;

import android.app.Activity;
import android.view.View;

/**
 * 
 * Copyright © 2014ENGC. All rights reserved.
 * @Title: ViewUtility.java
 * @Package: com.engc.smartedu.utils
 * @Description: 视图帮助�?
 * @author: wutao  
 * @date: 2014-4-25 下午2:30:06
 */
public class ViewUtility {
	@SuppressWarnings({"unchecked", "UnusedDeclaration"})
    public static <T extends View> T findViewById(View view, int id) {
        return (T) view.findViewById(id);
    }

    @SuppressWarnings({"unchecked", "UnusedDeclaration"})
    public static <T extends View> T findViewById(Activity activity, int id) {
        return (T) activity.findViewById(id);
    }

}
