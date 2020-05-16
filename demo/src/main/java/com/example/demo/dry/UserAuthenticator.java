package com.example.demo.dry;

import org.apache.commons.lang3.StringUtils;

/**
 * 在代码中，有两处非常明显的重复代码片段：isValidUsername()函数和isValidPassword()函数
 * 重复的代码被敲了两遍，或者简单copy-paste了一下，看起来明显违反DRY原则。
 * 为了移除重复的代码，我们对上面的代码做下重构，将isValidUserName()函数和isValidPassword()函数，合并为一个更通用的函数isValidUserNameOrPassword()
 */
public class UserAuthenticator {

    public void authenticate(String username, String password) {
        if (!isValidUsername(username)) {
            // ...throw InvalidUsernameException...
        }
        if (!isValidPassword(password)) {
            // ...throw InvalidPasswordException...
        }
        //...省略其他代码...
    }

    private boolean isValidUsername(String username) { // check not null, not empty
        if (StringUtils.isBlank(username)) {
            return false;
        }
        // check length: 4~64
        int length = username.length();
        if (length < 4 || length > 64) {
            return false;
        }
        // contains only lowcase characters
        if (!StringUtils.isAllLowerCase(username)) {
            return false;
        }
        // contains only a~z,0~9,dot
        for (int i = 0; i < length; ++i) {
            char c = username.charAt(i);
            if (!(c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '.') {
                return false;
            }
        }
        return true;
    }

    private boolean isValidPassword(String password) { // check not null, not empty
        if (StringUtils.isBlank(password)) {
            return false;
        }
        // check length: 4~64
        int length = password.length();
        if (length < 4 || length > 64) {
            return false;
        }
        // contains only lowcase characters
        if (!StringUtils.isAllLowerCase(password)) {
            return false;
        }
        // contains only a~z,0~9,dot
        for (int i = 0; i < length; ++i) {
            char c = password.charAt(i);
            if (!(c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '.') {
                return false;
            }
        }
        return true;
    }

    /**
     * 重构后的代码如下所示:
     */
    public class UserAuthenticatorV2 {
        public void authenticate(String userName, String password) {
            if (!isValidUsernameOrPassword(userName)) {
                // ...throw InvalidUsernameException... }
                if (!isValidUsernameOrPassword(password)) { // ...throw InvalidPasswordException...
                }
            }

        }

        /**
         * 将isValidUserName()函数和isValidPassword()函数，合并为一个更通用的函数isValidUserNameOrPassword()
         *
         * 问题1：单从名字上，我们就能发现，
         * 合并之后的isValidUsernameOrPassword()函数，负责了两件事情：验证用户名和验证密码，违反了"单一职责原则"和"接口隔离原则"
         * 问题2：实际上，即便将两个函数合并成isValidUsernameOrPassword()，代码仍然存在问题。
         * 因为isValidUserName()和isValidPassword()两个函数，虽然从代码实现逻辑上看起来是重复的，但是语义上并不重复。
         * 所谓"语义不重复"指的是：从功能上来看，这两个函数干的是完全不重复的两件事情，一个是校验用户名，另一个是校验密码。
         * 尽管在目前的设计中，两个校验逻辑是完全一样的，但如果按照第二种写法，将两个函数合并，那就会存在潜在的问题。
         * 在未来某一天，如果我们修改了密码校验的逻辑，比如，允许密码包含大写字符，允许密码的长度为8-64个字符，那这个时候，isValidUserName()和 isValidPassword()的实现逻辑就会不相同。我们就要把合并后的函数，重新拆成合并前的那两个函数。
         * 尽管代码的实现逻辑是相同的，但语义不同，我们判定它并不违反DRY原则。对于包含重复代码的问题，我们可以通过抽象成更细粒度函数的方式来解决。
         * 比如将校验只包含a~z、0~9、dot的路基封装成 boolean onlyContains(String str, String charList)函数
         * @param usernameOrPassword
         * @return
         */
        private boolean isValidUsernameOrPassword(String usernameOrPassword){
            //省略实现逻辑 //跟原来的isValidUsername()或isValidPassword()的实现逻辑一样...
            return true;
        }
    }

}