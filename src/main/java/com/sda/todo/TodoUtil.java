package com.sda.todo;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class TodoUtil {

   public static boolean isWriteRequest(HttpServletRequest req) {

       //wyciagamy mape z requestu
       Map<String, String[]> parameterMap = req.getParameterMap();
       return exists("name", parameterMap) &&
               exists("description", parameterMap) &&
               exists("priority", parameterMap) &&
               exists("date", parameterMap);


       //sprawdzam w tej parameter mapie czy posiada dany klucz (name, descrip, checked, date)
//       return parameterMap.containsKey("name") &&
//               parameterMap.containsKey("description") &&
//               parameterMap.containsKey("priority") &&
//               parameterMap.containsKey("date");
   }

   private static boolean exists(String param, Map<String, String[]> map) {
       return map.containsKey(param) && StringUtils.isNotEmpty(map.get(param)[0]);
   }
}
