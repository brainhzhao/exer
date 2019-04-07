package priv.zh.inteceptor;

import org.springframework.web.servlet.handler.*;
import javax.servlet.http.*;

public class RedirectInterceptor extends HandlerInterceptorAdapter{

    @Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
        System.out.println("你好啊，被拦截了吧");
		return true;
    }
    

}