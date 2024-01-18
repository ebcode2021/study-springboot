package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username = {}, age = {}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {
        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }

    // 컴파일 시, debug enabled가 될 때만 가능한 코드
//    @ResponseBody
//    @RequestMapping("/request-param-v3")
//    public String requestParamV3(
//            @RequestParam String username,
//            @RequestParam int age) {
//        log.info("username={}, age={}", username, age);
//        return "ok";
//    }

//    @ResponseBody
//    @RequestMapping("/request-param-v4")
//    public String requestParamV4(String username, int age) {
//        log.info("username={}, age={}", username, age);
//        return "ok";
//   }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "age", required = false) Integer age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(value = "username", required = true, defaultValue = "guest") String username,
            @RequestParam(value="age", required = false, defaultValue = "-1") Integer age){
        log.info("username={}, age={}", username, age);
        return "ok"; //ok라는 문자열을 http 응답 메세지에 넣어서 반환
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }
}
