package cn.leithda.shiro;

import cn.leithda.model.Permission;
import cn.leithda.model.Role;
import cn.leithda.model.User;
import cn.leithda.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/25
 * Description: 认证类
 */
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    // 用于判断是否进行处理
    @Override
    public boolean supports(AuthenticationToken token) {
        return super.supports(token);
//        return toekn instanceof UsernamePasswordToken;    // 仅支持UsernamePasswordToken类型的Token
    }

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        User user = (User) principalCollection.getPrimaryPrincipal();   // 获取到登录用户

        Set<String> permissionList = new HashSet<>();
        Set<Role> roleSet = user.getRoles();
        Set<String> roleNameSet = new HashSet<>();
        if (CollectionUtils.isNotEmpty(roleSet)) {
            for (Role role : roleSet) {
                roleNameSet.add(role.getRname());
                Set<Permission> permissionSet = role.getPermissions();
                for (Permission permission : permissionSet) {
                    permissionList.add(permission.getName());
                }
            }
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roleNameSet);    // 角色
        info.setStringPermissions(permissionList);    // 权限
        return info;
    }

    // 认证登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }
}
