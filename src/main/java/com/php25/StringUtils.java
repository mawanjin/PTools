package com.php25;

/**
 * Created with penghuiping
 * User: penghuiping
 * Date: 14-8-7
 * Time: 下午8:07
 * To change this template use File | Settings | File Templates.
 */
public class StringUtils {
    public static Boolean isEmpty(String value) {
          if(null!=value && value.trim().length() != 0) {
              return false;
          }else {
              return true;
          }
    }
}
