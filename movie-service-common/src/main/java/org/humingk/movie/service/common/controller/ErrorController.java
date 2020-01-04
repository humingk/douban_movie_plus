package org.humingk.movie.service.common.controller;

/**
 * @author humingk
 */
//@RestController
//@RequestMapping("/")
//public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
//    @Autowired
//    private HttpServletRequest request;
//
//    /**
//     * 错误页面处理
//     *
//     * @return
//     */
//    @RequestMapping("error")
//    public Result error() {
//        int status = (int) request.getAttribute("javax.servlet.error.status_code");
//        switch (status) {
//            case 400:
//            case 405:
//                return Result.error(StatusAndMessage.BADREQUEST);
//            case 401:
//                return Result.error(StatusAndMessage.UNAUTHORIZED);
//            case 403:
//                return Result.error(StatusAndMessage.FORBIDDEN);
//            case 404:
//                return Result.notFound();
//            default:
//                return Result.error();
//        }
//    }
//
//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }
//}
