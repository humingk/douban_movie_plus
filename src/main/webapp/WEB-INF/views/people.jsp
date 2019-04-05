<%--
  Created by IntelliJ IDEA.
  User: humin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script src="https://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">
    <script type="text/javascript">

    </script>

</head>
<body>
people 个人主页<br>

更新所有的想看电影和已看电影
<button onclick="updateWishsAndSeens('humingk')" value="update">更新</button>
<button onclick="getWishsAndSeens('humingk')" value="getWishsAndSeens">获取wishsAndSeens</button>


    <script type="text/javascript">

        var currentUser = ${currentUser}

        $(document).ready(function () {
        });

        // 获取wishsAndSeens
        function getWishsAndSeens(label) {
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "/people/getWishsAndSeens?label=" + label,
                success: function (result) {
                    // ===============================================================
                    console.log("getwishsAndSeens : ");
                    console.log(result);
                }
            });
        }

        // 更新wishsAndSeens
        function updateWishsAndSeens(label) {
            $.ajax({
                type: "GET",
                url: "/people/updateWishsAndSeens?label=" + label,
                success: function (result) {
                    // ===============================================================
                    console.log("updateWishsAndSeens: OK")
                }
            });
        }


    </script>

</body>
</html>