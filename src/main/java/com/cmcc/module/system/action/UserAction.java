package com.cmcc.module.system.action;

import com.cmcc.module.common.action.BaseAction;
import com.cmcc.module.system.bean.UserBean;
import com.cmcc.module.system.dao.UserDaoImpl;

public class UserAction extends BaseAction {
    private static final long serialVersionUID = -2724484153902555164L;

    // µÇÂ¼Èë¿Ú
	public void login() {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		UserBean user = null;
		if (userid != null && userid != "" && password != null && password != "") {
			user = new UserDaoImpl().getUser(userid, password);
		}
        if (user != null) {
			retMsg = user.getUser_name();
		} else {
			retMsg = "";
		}
		finish();
	}
}
